package co.chop.friends.list.domain

import com.combyne.repository.ResultModel

interface FriendListRepository {
    suspend fun getFriendList(): ResultModel<MutableList<FriendListDataModel>>
}