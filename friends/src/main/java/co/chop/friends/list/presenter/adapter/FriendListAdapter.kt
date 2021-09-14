package co.chop.friends.list.presenter.adapter

import android.view.ViewGroup
import co.chop.friends.R
import co.chop.friends.databinding.ItemFriendListBinding
import co.chop.friends.list.presenter.adapter.viewholder.item.FriendListModel
import co.chop.friends.list.presenter.adapter.viewholder.item.FriendListViewHolder
import com.combyne.uikit.base.adapter.BaseRecyclerAdapter
import com.combyne.uikit.base.adapter.BaseViewHolder
import com.combyne.uikit.extension.permitive.inflate


class FriendListAdapter(val onclickListener: (transitionId: String) -> Unit) :
    BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when (viewType) {
            R.layout.item_friend_list -> {
                FriendListViewHolder(
                    binding = ItemFriendListBinding.bind(parent.inflate(viewType)),
                    onclickListener = onclickListener
                )
            }
            else -> {
                FriendListViewHolder(
                    binding = ItemFriendListBinding.bind(parent.inflate(viewType)),
                    onclickListener = onclickListener
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mItems[position]) {
            is FriendListModel -> {
                // Item
                R.layout.item_friend_list
            }
            else -> 0
        }
    }
}