package co.chop.friends.list.domain

import co.chop.assessment.base.usecase.AsyncSuspendUseCase
import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.map


class FriendListUseCase(
    private val repository: FriendListRepository
) : AsyncSuspendUseCase<Unit, ResultModel<List<FriendModel>>> {

    override suspend fun executeAsync(rq: Unit): ResultModel<List<FriendModel>> {
        return repository.getFriendList().map {
            it.map { response ->
                FriendModel(
                    id = response.id ?: 0,
                    name = response.username,
                    lastMessage = response.lastMessage ?: ""
                )
            }
        }
    }
}