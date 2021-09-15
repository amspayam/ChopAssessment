package co.chop.friends.list.domain

import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class FriendListUseCase(
    private val repository: FriendListRepository
) : AsyncSuspendUseCase<Unit, ResultModel<List<FriendModel>>> {

    override suspend fun executeAsync(rq: Unit): ResultModel<List<FriendModel>> {
        return repository.getFriendList().map {
            it.map { response ->
                FriendModel(
                    id = response.id ?: 0,
                    name = response.username
                )
            }
        }
    }
}