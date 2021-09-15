package co.chop.conversation.data

import co.chop.conversation.domain.model.ConversationDataModel
import co.chop.conversation.domain.ConversationRepository
import co.chop.conversation.domain.model.ConversationEnum
import com.combyne.repository.ResultModel

class ConversationRepositoryImpl : ConversationRepository {

    private val list = mutableListOf(
        ConversationDataModel(
            userId = 1,
            message = "How Are You?",
            type = ConversationEnum.SENT
        ), ConversationDataModel(
            userId = 1,
            message = "Good",
            type = ConversationEnum.RECEIVED
        ), ConversationDataModel(
            userId = 2,
            message = "Hello",
            type = ConversationEnum.SENT
        )
    )

    override suspend fun getConversation(userId: Int): ResultModel<List<ConversationDataModel>> {
        val filteredList = list.filter { it.userId == userId }
        return ResultModel.Success(filteredList)
    }

    override suspend fun sendMessage(message: ConversationDataModel): ResultModel<List<ConversationDataModel>> {
        list.add(message)
        val filteredList = list.filter { it.userId == message.userId }
        return ResultModel.Success(filteredList)
    }
}