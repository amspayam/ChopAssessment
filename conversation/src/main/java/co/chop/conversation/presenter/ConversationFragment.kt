package co.chop.conversation.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import co.chop.conversation.databinding.FragmentConversationBinding
import com.combyne.uikit.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationFragment : BaseFragment<ConversationViewModel>() {

    override val viewModel: ConversationViewModel by viewModel()
    private lateinit var binding: FragmentConversationBinding
    private val args: ConversationFragmentArgs by navArgs()

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
    }

    override fun setupObserveData() {

    }


}