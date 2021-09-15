package co.chop.conversation.domain.model

import co.chop.assessment.room.entity.conversation.ConversationTypeEnum

data class ConversationModel(
    val userId: Int,
    val message: String,
    val type: ConversationTypeEnum
)
