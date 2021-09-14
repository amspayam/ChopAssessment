package co.chop.friends.list.presenter.adapter.viewholder.item

import co.chop.friends.databinding.ItemFriendListBinding
import com.combyne.uikit.base.adapter.BaseViewHolder

class FriendListViewHolder(
    val onclickListener: (transitionId: String) -> Unit,
    val binding: ItemFriendListBinding
) :
    BaseViewHolder<FriendListModel>(binding.root) {

    override fun bind(data: FriendListModel) {
        binding.friendNameTextView.text = data.name
        binding.friendMessageTextView.text = data.message
        binding.root.setOnClickListener {
            onclickListener.invoke(data.id)
        }
    }
}