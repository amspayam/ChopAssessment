package co.chop.conversation.domain

import co.chop.conversation.domain.model.ConversationDataModel
import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class SendMessageUseCase(
    private val repository: ConversationRepository
) : AsyncSuspendUseCase<ConversationDataModel, ResultModel<List<ConversationDataModel>>> {

    override suspend fun executeAsync(rq: ConversationDataModel): ResultModel<List<ConversationDataModel>> {
        return repository.sendMessage(message = rq).map {
            it
        }
    }
}