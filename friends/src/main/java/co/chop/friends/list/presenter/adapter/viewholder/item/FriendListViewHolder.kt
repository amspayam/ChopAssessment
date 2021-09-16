package co.chop.friends.list.presenter.adapter.viewholder.item

import co.chop.friends.databinding.ItemFriendListBinding
import co.chop.friends.list.domain.FriendModel
import com.combyne.uikit.base.adapter.BaseViewHolder

class FriendListViewHolder(
    val onclickListener: (friendId: Int, friendName: String) -> Unit,
    val binding: ItemFriendListBinding
) :
    BaseViewHolder<FriendModel>(binding.root) {

    override fun bind(data: FriendModel) {
        binding.friendNameTextView.text = data.name
        binding.friendMessageTextView.text = data.lastMessage
        binding.root.setOnClickListener {
            onclickListener.invoke(data.id, data.name)
        }
    }
}