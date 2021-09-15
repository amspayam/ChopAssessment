package co.chop.conversation.presenter.adapter.viewholder.sent

import co.chop.conversation.databinding.ItemConversationSentBinding
import com.combyne.uikit.base.adapter.BaseViewHolder

class ConversationSentViewHolder(
    val binding: ItemConversationSentBinding
) :
    BaseViewHolder<ConversationSentModel>(binding.root) {

    override fun bind(data: ConversationSentModel) {
        binding.sentMessageTextView.text = data.message
    }
}