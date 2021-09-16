package co.chop.friends.list.data

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.db.AppDatabase
import co.chop.assessment.room.entity.friend.FriendEntity
import co.chop.friends.list.domain.FriendListRepository
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.flow.Flow

class FriendListRepositoryImpl(private val dataBaseManager: AppDatabase) :
    FriendListRepository {

    override suspend fun getFriendList(): ResultModel<Flow<List<FriendEntity>>> {
        return try {
            ResultModel.Success(dataBaseManager.friendDao().getFriends())
        } catch (exception: ApolloException) {
            ResultModel.Error(
                exception.localizedMessage ?: "Error"
            )
        }
    }

}