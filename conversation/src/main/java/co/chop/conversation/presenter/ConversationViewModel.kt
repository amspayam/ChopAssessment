package co.chop.conversation.presenter

import co.chop.conversation.domain.ConversationUseCase
import com.combyne.uikit.base.viewmodel.BaseViewModel

class ConversationViewModel(private val conversationUseCase: ConversationUseCase) :
    BaseViewModel() {
    fun bindArguments(args: ConversationFragmentArgs) {

    }

}