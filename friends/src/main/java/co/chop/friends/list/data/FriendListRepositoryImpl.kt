package co.chop.friends.list.data

import co.chop.friends.list.domain.FriendListRepository
import co.chope.room.entity.friend.FriendEntity
import com.combyne.repository.ResultModel
import com.combyne.repository.db.AppDatabase
import kotlinx.coroutines.*

class FriendListRepositoryImpl(private val dataBaseManager: AppDatabase) :
    FriendListRepository {

    override suspend fun getFriendList(): ResultModel<List<FriendEntity>> {
        val resultModel: ResultModel<List<FriendEntity>>
        withContext(Dispatchers.Main) {
            resultModel = ResultModel.Success(dataBaseManager.friendDao().getFriends())
        }
        return resultModel
    }
}