package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationDataModel
import com.combyne.repository.ResultModel

interface ConversationRepository {
    suspend fun getConversation(userId: Int): ResultModel<List<ConversationDataModel>>
    suspend fun sendMessage(message: ConversationDataModel): ResultModel<List<ConversationDataModel>>
}