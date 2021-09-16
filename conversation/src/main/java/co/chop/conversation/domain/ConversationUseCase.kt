package co.chop.conversation.domain

import co.chop.assessment.base.usecase.AsyncSuspendUseCase
import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.map
import co.chop.conversation.domain.model.ConversationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class ConversationUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<Int, ResultModel<Flow<List<ConversationModel>>>> {

    override suspend fun executeAsync(rq: Int): ResultModel<Flow<List<ConversationModel>>> {
        return repository.getConversation(idUser = rq).map {
            it.map { response ->
                response?.map { item ->
                    ConversationModel(
                        userId = item.userId,
                        message = item.message,
                        type = item.type
                    )
                } ?: listOf()
            }
        }
    }
}