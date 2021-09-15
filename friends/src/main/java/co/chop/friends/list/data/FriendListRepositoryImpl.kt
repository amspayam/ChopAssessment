package co.chop.friends.list.data

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.db.AppDatabase
import co.chop.assessment.room.entity.friend.FriendEntity
import co.chop.friends.list.domain.FriendListRepository

class FriendListRepositoryImpl(private val dataBaseManager: AppDatabase) :
    FriendListRepository {

    override suspend fun getFriendList(): ResultModel<List<FriendEntity>> {
        return ResultModel.Success(dataBaseManager.friendDao().getFriends())
    }

}