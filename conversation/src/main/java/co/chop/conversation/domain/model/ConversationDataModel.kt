package co.chop.conversation.domain.model

data class ConversationDataModel(
    val userId: Int,
    val message: String,
    val type: ConversationEnum
)
