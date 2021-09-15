package co.chop.friends.list.presenter

import androidx.lifecycle.MutableLiveData
import co.chop.friends.list.domain.FriendModel
import co.chop.friends.list.domain.FriendListUseCase
import co.chop.friends.list.presenter.adapter.viewholder.item.FriendListModel
import com.combyne.core.view.ViewState
import com.combyne.repository.executeUseCase
import com.combyne.uikit.base.viewmodel.BaseViewModel
import com.combyne.uikit.extension.mutablelivedata.notifyObserver

class FriendListViewModel(private val friendListUseCase: FriendListUseCase) : BaseViewModel() {

    val friendListViewStateLiveData = MutableLiveData<ViewState<List<FriendModel>>>()
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

    private fun prepareItemsForAdapter(it: List<FriendModel>) {
        friendListItemsLiveData.value?.clear()
        friendListItemsLiveData.value?.addAll(it.map {
            FriendListModel(
                id = it.id,
                name = it.name,
                message = ""
            )
        })
        friendListItemsLiveData.notifyObserver()
    }

}