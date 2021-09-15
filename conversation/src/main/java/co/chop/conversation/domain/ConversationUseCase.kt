package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationModel
import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class ConversationUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<Int, ResultModel<List<ConversationModel>>> {

    override suspend fun executeAsync(rq: Int): ResultModel<List<ConversationModel>> {
        return repository.getConversation(idUser = rq).map {
            it.map { response ->
                ConversationModel(
                    userId = response.userId,
                    message = response.message,
                    type = response.type
                )
            }
        }
    }
}