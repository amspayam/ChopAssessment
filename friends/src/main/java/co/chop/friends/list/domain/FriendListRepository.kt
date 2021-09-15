package co.chop.friends.list.domain

import co.chope.room.entity.friend.FriendEntity
import com.combyne.repository.ResultModel

interface FriendListRepository {
    suspend fun getFriendList(): ResultModel<List<FriendEntity>>
}