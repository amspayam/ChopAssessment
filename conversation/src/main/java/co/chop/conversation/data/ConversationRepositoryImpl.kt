package co.chop.conversation.data

import co.chop.conversation.domain.ConversationDataModel
import co.chop.conversation.domain.ConversationRepository
import com.combyne.repository.ResultModel

class ConversationRepositoryImpl : ConversationRepository {
    override suspend fun getFriendList(): ResultModel<MutableList<ConversationDataModel>> {
        val list = mutableListOf<ConversationDataModel>()
        list.add(
            ConversationDataModel(id = "1", name = "Jone", lastMessage = "How are you?")
        )
        list.add(
            ConversationDataModel(id = "2", name = "Kent", lastMessage = "Hello")
        )
        return ResultModel.Success(list)
    }
}