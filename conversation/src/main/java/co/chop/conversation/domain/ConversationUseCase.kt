package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationDataModel
import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class ConversationUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<Int, ResultModel<List<ConversationDataModel>>> {

    override suspend fun executeAsync(rq: Int): ResultModel<List<ConversationDataModel>> {
        return repository.getConversation(userId = rq).map {
            it
        }
    }
}