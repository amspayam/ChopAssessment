package co.chop.conversation.domain

import com.combyne.repository.ResultModel

interface ConversationRepository {
    suspend fun getFriendList(): ResultModel<MutableList<ConversationDataModel>>
}