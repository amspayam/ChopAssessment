package co.chop.friends.list.domain

import co.chop.assessment.base.usecase.AsyncSuspendUseCase
import co.chop.assessment.repository.ResultModel
import co.chop.assessment.repository.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class FriendListUseCase(
    private val repository: FriendListRepository
) : AsyncSuspendUseCase<Unit, ResultModel<Flow<List<FriendModel>>>> {

    override suspend fun executeAsync(rq: Unit): ResultModel<Flow<List<FriendModel>>> {
        return repository.getFriendList().map {
            it.map { response ->
                response.map { item ->
                    FriendModel(
                        id = item.id ?: 0,
                        name = item.username,
                        lastMessage = item.lastMessage ?: ""
                    )
                }
            }
        }
    }
}