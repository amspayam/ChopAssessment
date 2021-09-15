package co.chop.friends.list.domain

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.room.entity.friend.FriendEntity

interface FriendListRepository {
    suspend fun getFriendList(): ResultModel<List<FriendEntity>>
}