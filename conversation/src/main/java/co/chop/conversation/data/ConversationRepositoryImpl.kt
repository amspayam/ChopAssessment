package co.chop.conversation.data

import co.chop.conversation.domain.ConversationRepository
import co.chop.conversation.domain.model.ConversationModel
import co.chope.room.entity.conversation.ConversationEntity
import com.combyne.repository.ResultModel
import com.combyne.repository.db.AppDatabase

class ConversationRepositoryImpl(private val appDatabase: AppDatabase) :
    ConversationRepository {

    override suspend fun getConversation(idUser: Int) =
        ResultModel.Success(appDatabase.conversationDao().getAll(idUser))

    override suspend fun addConversation(conversation: ConversationModel): ResultModel<Boolean> {
        appDatabase.conversationDao().insert(
            ConversationEntity(
                id = null,
                userId = conversation.userId,
                message = conversation.message,
                type = conversation.type
            )
        )
        return ResultModel.Success(true)
    }

}