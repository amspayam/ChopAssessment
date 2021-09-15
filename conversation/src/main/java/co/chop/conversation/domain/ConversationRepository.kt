package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationModel
import co.chope.room.entity.conversation.ConversationEntity
import com.combyne.repository.ResultModel

interface ConversationRepository {
    suspend fun getConversation(idUser: Int): ResultModel<List<ConversationEntity>?>
    suspend fun addConversation(conversation: ConversationModel): ResultModel<Int>
}