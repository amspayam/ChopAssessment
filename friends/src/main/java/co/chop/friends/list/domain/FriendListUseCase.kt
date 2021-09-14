package co.chop.friends.list.domain

import com.combyne.core.usecase.AsyncSuspendUseCase
import com.combyne.repository.ResultModel
import com.combyne.repository.map


class FriendListUseCase(
    private val repository: FriendListRepository
) : AsyncSuspendUseCase<Unit, ResultModel<MutableList<FriendListDataModel>>> {

    override suspend fun executeAsync(rq: Unit): ResultModel<MutableList<FriendListDataModel>> {
        return repository.getFriendList().map {
            it
        }
    }
}