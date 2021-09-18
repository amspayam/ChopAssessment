package co.chop.conversation.data

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.db.AppDatabase
import co.chop.assessment.room.entity.conversation.ConversationEntity
import co.chop.assessment.room.entity.conversation.ConversationTypeEnum
import co.chop.assessment.room.entity.friend.FriendUpdate
import co.chop.conversation.domain.ConversationRepository
import co.chop.conversation.domain.model.ConversationModel
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.flow.Flow

class ConversationRepositoryImpl(private val appDatabase: AppDatabase) :
    ConversationRepository {

    override suspend fun getConversation(idUser: Int): ResultModel<Flow<List<ConversationEntity>?>> {
        return try {
            ResultModel.Success(appDatabase.conversationDao().getAll(idUser))
        } catch (exception: java.lang.Exception) {
            ResultModel.Error(
                exception.localizedMessage ?: "Error"
            )
        }
    }

    override suspend fun addConversation(conversation: ConversationModel): ResultModel<Int> {
        /*Add message*/
        val conversations = listOf(
            ConversationEntity(
                id = null,
                userId = conversation.userId,
                message = conversation.message,
                type = conversation.type
            ),
            ConversationEntity(
                id = null,
                userId = conversation.userId,
                message = conversation.message,
                type = ConversationTypeEnum.RECEIVED
            )
        )
        return try {
            appDatabase.conversationDao().insertConversations(conversation = conversations)

            /*Add last message to friend*/
            appDatabase.friendDao().updateFriend(
                FriendUpdate(
                    id = conversation.userId,
                    lastMessage = conversation.message
                )
            )
            ResultModel.Success(conversation.userId)
        } catch (exception: Exception) {
            ResultModel.Error(exception.localizedMessage ?: "")
        }
    }

}