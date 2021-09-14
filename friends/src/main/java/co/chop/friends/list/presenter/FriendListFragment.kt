package co.chop.friends.list.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.chop.friends.databinding.FragmentFriendListBinding
import co.chop.friends.list.presenter.adapter.FriendListAdapter
import co.chop.friends.list.presenter.adapter.FriendListDecoration
import com.combyne.core.view.onViewData
import com.combyne.core.view.onViewError
import com.combyne.core.view.onViewLoading
import com.combyne.uikit.base.BaseFragment
import com.combyne.uikit.base.viewmodel.MessageMaster
import com.combyne.uikit.base.viewmodel.MessageTypeEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendListFragment : BaseFragment<FriendListViewModel>() {

    override val viewModel: FriendListViewModel by viewModel()
    private lateinit var binding: FragmentFriendListBinding
    private val friendListAdapter by lazy {
        FriendListAdapter(onclickListener = { friendId, friendName ->
            navigateToFriendDetailFragment(friendId, friendName)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        initialRecyclerview()
    }

    override fun setupObserveData() {

        // <editor-fold desc="Observe Friend List">
        viewModel.friendListViewStateLiveData.observe(viewLifecycleOwner) {
            it.onViewLoading { binding.swipeRefresh.isRefreshing = true }
                .onViewData {
                    binding.swipeRefresh.isRefreshing = false
                }.onViewError { messages, status ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                    binding.swipeRefresh.isRefreshing = false
                }
        }
        // </editor-fold>

        // <editor-fold desc="Observe Adapter">
        viewModel.friendListItemsLiveData.observe(viewLifecycleOwner) {
            friendListAdapter.setItems(it)
        }
        // </editor-fold>
    }

    private fun initialRecyclerview() {
        binding.friendsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.friendsRecyclerView.addItemDecoration(FriendListDecoration(requireContext()))
        binding.friendsRecyclerView.adapter = friendListAdapter
    }

    private fun navigateToFriendDetailFragment(friendId: String, friendName: String) {
        val action =
            FriendListFragmentDirections.actionFriendsFragmentToConversationFragment(
                friendId,
                friendName
            )
        findNavController().navigate(action)
    }

}