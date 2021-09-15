package co.chop.friends.list.data

import co.chop.friends.list.domain.FriendListDataModel
import co.chop.friends.list.domain.FriendListRepository
import com.combyne.repository.ResultModel

class FriendListRepositoryImpl : FriendListRepository {
    override suspend fun getFriendList(): ResultModel<MutableList<FriendListDataModel>> {
        val list = mutableListOf<FriendListDataModel>()
        list.add(
            FriendListDataModel(id = 1, name = "Jone", lastMessage = "How are you?")
        )
        list.add(
            FriendListDataModel(id = 2, name = "Kent", lastMessage = "Hello")
        )
        return ResultModel.Success(list)
    }
}