package co.chop.friends.list.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.chop.assessment.base.view.ViewState
import co.chop.assessment.repository.executeUseCase
import co.chop.friends.list.domain.FriendListUseCase
import co.chop.friends.list.domain.FriendModel
import com.combyne.uikit.base.viewmodel.BaseViewModel
import com.combyne.uikit.extension.mutablelivedata.notifyObserver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FriendListViewModel(
    private val friendListUseCase: FriendListUseCase
) : BaseViewModel() {

    val friendListViewStateLiveData = MutableLiveData<ViewState<Flow<List<FriendModel>>>>()
    val friendListItemsLiveData = MutableLiveData<MutableList<Any>>(mutableListOf())

    init {
        getFriends()
    }

    fun getFriends() {
        friendListViewStateLiveData.value = ViewState.ViewLoading
        track {
            friendListUseCase.executeAsync(Unit)
                .executeUseCase({
                    prepareItemsForAdapter(it)
                    friendListViewStateLiveData.value = ViewState.ViewData(it)
                }, {
                    friendListViewStateLiveData.value = ViewState.ViewError(it)
                })
        }
    }

    private fun prepareItemsForAdapter(items: Flow<List<FriendModel>>) {
        viewModelScope.launch {
            items.collect { item ->
                friendListItemsLiveData.value?.clear()
                friendListItemsLiveData.value?.addAll(item)
                friendListItemsLiveData.notifyObserver()
            }
        }
    }

}