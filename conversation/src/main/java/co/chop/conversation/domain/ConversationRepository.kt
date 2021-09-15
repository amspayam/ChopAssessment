package co.chop.conversation.domain

import co.chop.assessment.repository.ResultModel
import co.chop.assessment.room.entity.conversation.ConversationEntity
import co.chop.conversation.domain.model.ConversationModel

interface ConversationRepository {
    suspend fun getConversation(idUser: Int): ResultModel<List<ConversationEntity>?>
    suspend fun addConversation(conversation: ConversationModel): ResultModel<Int>
}