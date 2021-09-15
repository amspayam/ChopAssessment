package co.chop.conversation.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.chop.conversation.R
import co.chop.conversation.databinding.FragmentConversationBinding
import co.chop.conversation.presenter.adapter.ConversationAdapter
import co.chop.conversation.presenter.adapter.ConversationDecoration
import com.combyne.core.view.onViewData
import com.combyne.core.view.onViewError
import com.combyne.core.view.onViewLoading
import com.combyne.uikit.base.BaseFragment
import com.combyne.uikit.base.viewmodel.MessageMaster
import com.combyne.uikit.base.viewmodel.MessageTypeEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationFragment : BaseFragment<ConversationViewModel>() {

    override val viewModel: ConversationViewModel by viewModel()
    private lateinit var binding: FragmentConversationBinding
    private val args: ConversationFragmentArgs by navArgs()
    private val conversationAdapter by lazy {
        ConversationAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConversationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        viewModel.bindArguments(args)
        binding.toolbar.text = args.name
        initialRecyclerview()
    }

    override fun setupObserveData() {
        // <editor-fold desc="Observe Conversation">
        viewModel.conversationViewStateLiveData.observe(viewLifecycleOwner) {
            it.onViewError { messages, status ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                }
        }
        // </editor-fold>

        // <editor-fold desc="Observe Send Message">
        viewModel.sendMessageLiveData.observe(viewLifecycleOwner) {
            it.onViewLoading { binding.sendButton.startLoading() }
                .onViewData { sent ->
                    if (sent)
                        binding.messageEditText.text = ""
                    binding.sendButton.stopLoading()
                }.onViewError { messages, status ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                    binding.sendButton.stopLoading()
                }
        }
        // </editor-fold>

        // <editor-fold desc="Observe Adapter">
        viewModel.conversationItemsLiveData.observe(viewLifecycleOwner) {
            conversationAdapter.setItems(it)
        }
        // </editor-fold>
    }

    override fun setupListener() {
        super.setupListener()
        onClickListeners(binding.sendButton)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        viewModel.sendMessage(message = binding.messageEditText.text)
    }

    private fun initialRecyclerview() {
        binding.conversationRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.conversationRecyclerView.addItemDecoration(ConversationDecoration(requireContext()))
        binding.conversationRecyclerView.adapter = conversationAdapter
    }

    override fun showMessage(message: MessageMaster) {
        binding.sendButton.stopLoading()
        super.showMessage(message)
        if (message.type == MessageTypeEnum.VIEW) {
            when (message.viewId) {
                R.id.messageEditText -> binding.messageEditText.setError(
                    message.text
                )
            }
        }
    }


}