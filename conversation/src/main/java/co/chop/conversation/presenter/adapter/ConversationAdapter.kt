package co.chop.conversation.presenter.adapter

import android.view.ViewGroup
import co.chop.conversation.R
import co.chop.conversation.databinding.ItemConversationReceivedBinding
import co.chop.conversation.databinding.ItemConversationSentBinding
import co.chop.conversation.presenter.adapter.viewholder.received.ConversationReceivedModel
import co.chop.conversation.presenter.adapter.viewholder.received.ConversationReceivedViewHolder
import co.chop.conversation.presenter.adapter.viewholder.sent.ConversationSentModel
import co.chop.conversation.presenter.adapter.viewholder.sent.ConversationSentViewHolder
import com.combyne.uikit.base.adapter.BaseRecyclerAdapter
import com.combyne.uikit.base.adapter.BaseViewHolder
import com.combyne.uikit.extension.permitive.inflate


class ConversationAdapter :
    BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when (viewType) {
            R.layout.item_conversation_sent -> {
                ConversationSentViewHolder(
                    binding = ItemConversationSentBinding.bind(parent.inflate(viewType))
                )
            }
            R.layout.item_conversation_received -> {
                ConversationReceivedViewHolder(
                    binding = ItemConversationReceivedBinding.bind(parent.inflate(viewType)))
            }
            else -> {
                ConversationSentViewHolder(
                    binding = ItemConversationSentBinding.bind(parent.inflate(viewType))
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mItems[position]) {
            is ConversationSentModel -> {
                // Sent
                R.layout.item_conversation_sent
            }
            is ConversationReceivedModel -> {
                // Sent
                R.layout.item_conversation_received
            }
            else -> 0
        }
    }
}