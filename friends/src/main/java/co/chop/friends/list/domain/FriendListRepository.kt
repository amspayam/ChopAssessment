package co.chop.friends.list.domain

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.room.entity.friend.FriendEntity
import kotlinx.coroutines.flow.Flow

interface FriendListRepository {
    suspend fun getFriendList(): ResultModel<Flow<List<FriendEntity>>>
}