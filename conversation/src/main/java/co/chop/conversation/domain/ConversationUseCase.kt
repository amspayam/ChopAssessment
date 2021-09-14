package co.chop.conversation.domain

import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class ConversationUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<Unit, ResultModel<MutableList<ConversationDataModel>>> {

    override suspend fun executeAsync(rq: Unit): ResultModel<MutableList<ConversationDataModel>> {
        return repository.getFriendList().map {
            it
        }
    }
}