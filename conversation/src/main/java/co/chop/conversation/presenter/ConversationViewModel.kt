package co.chop.conversation.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.chop.assessment.base.view.ViewState
import co.chop.assessment.repository.executeUseCase
import co.chop.assessment.room.entity.conversation.ConversationTypeEnum
import co.chop.conversation.R
import co.chop.conversation.domain.ConversationUseCase
import co.chop.conversation.domain.SendMessageUseCase
import co.chop.conversation.domain.model.ConversationModel
import co.chop.conversation.presenter.adapter.viewholder.received.ConversationReceivedModel
import co.chop.conversation.presenter.adapter.viewholder.sent.ConversationSentModel
import com.combyne.uikit.base.viewmodel.BaseViewModel
import com.combyne.uikit.base.viewmodel.MessageMaster
import com.combyne.uikit.base.viewmodel.MessageTypeEnum
import com.combyne.uikit.extension.mutablelivedata.notifyObserver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ConversationViewModel(
    private val conversationUseCase: ConversationUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) :
    BaseViewModel() {

    val conversationViewStateLiveData =
        MutableLiveData<ViewState<Flow<List<ConversationModel>>>>()
    val conversationItemsLiveData = MutableLiveData<MutableList<Any>>(mutableListOf())
    val sendMessageLiveData = MutableLiveData<ViewState<Boolean>>()
    private var userId: Int = 0

    fun bindArguments(args: ConversationFragmentArgs) {
        userId = args.friendId
        getConversation(friendId = args.friendId)
    }

    private fun getConversation(friendId: Int) {
        conversationViewStateLiveData.value = ViewState.ViewLoading
        track {
            conversationUseCase.executeAsync(friendId)
                .executeUseCase({
                    prepareItemsForAdapter(it)
                    conversationViewStateLiveData.value = ViewState.ViewData(it)
                }, {
                    conversationViewStateLiveData.value = ViewState.ViewError(it)
                })
        }
    }

    private fun prepareItemsForAdapter(items: Flow<List<ConversationModel>>) {
        viewModelScope.launch {
            items.collect { item ->
                conversationItemsLiveData.value?.clear()
                item.forEach {
                    when (it.type) {
                        ConversationTypeEnum.SENT -> conversationItemsLiveData.value?.add(
                            ConversationSentModel(
                                message = it.message
                            )
                        )
                        ConversationTypeEnum.RECEIVED -> conversationItemsLiveData.value?.add(
                            ConversationReceivedModel(message = it.message)
                        )
                    }
                }
                conversationItemsLiveData.notifyObserver()
            }
        }
    }

    fun sendMessage(message: String?) {
        sendMessageLiveData.value = ViewState.ViewLoading
        val isValid =
            messageValidation(
                conversationMessage = message
            )
        if (!isValid)
            return

        track {
            sendMessageUseCase.executeAsync(
                ConversationModel(
                    userId = userId,
                    message = message!!,
                    type = ConversationTypeEnum.SENT
                )
            ).executeUseCase({
                getConversation(friendId = it)
                sendMessageLiveData.value = ViewState.ViewData(true)
            }, {
                sendMessageLiveData.value = ViewState.ViewError(it)
            })
        }
    }

    private fun messageValidation(conversationMessage: String?): Boolean {
        var isValid = true
        if (conversationMessage?.trim().isNullOrEmpty()) {
            message.value = MessageMaster(
                type = MessageTypeEnum.VIEW,
                messageResourceId = R.string.field_required,
                viewId = R.id.messageEditText
            )
            isValid = false
        }
        return isValid
    }


}