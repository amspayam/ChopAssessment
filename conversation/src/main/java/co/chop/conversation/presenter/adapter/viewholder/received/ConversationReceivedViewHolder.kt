package co.chop.conversation.presenter.adapter.viewholder.received

import co.chop.conversation.databinding.ItemConversationReceivedBinding
import com.combyne.uikit.base.adapter.BaseViewHolder

class ConversationReceivedViewHolder(
    val binding: ItemConversationReceivedBinding
) :
    BaseViewHolder<ConversationReceivedModel>(binding.root) {

    override fun bind(data: ConversationReceivedModel) {
        binding.receivedMessageTextView.text = data.message
    }
}