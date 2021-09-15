package co.chop.conversation.data

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.db.AppDatabase
import co.chop.assessment.room.entity.conversation.ConversationEntity
import co.chop.assessment.room.entity.conversation.ConversationTypeEnum
import co.chop.assessment.room.entity.friend.FriendUpdate
import co.chop.conversation.domain.ConversationRepository
import co.chop.conversation.domain.model.ConversationModel

class ConversationRepositoryImpl(private val appDatabase: AppDatabase) :
    ConversationRepository {

    override suspend fun getConversation(idUser: Int): ResultModel<List<ConversationEntity>?> {
        return ResultModel.Success(appDatabase.conversationDao().getAll(idUser))
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
        appDatabase.conversationDao().insertConversations(conversation = conversations)

        /*Add last message to friend*/
        appDatabase.friendDao().updateFriend(
            FriendUpdate(
                id = conversation.userId,
                lastMessage = conversation.message
            )
        )
        return ResultModel.Success(conversation.userId)
    }

}