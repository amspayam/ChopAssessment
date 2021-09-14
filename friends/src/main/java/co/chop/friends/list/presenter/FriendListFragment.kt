package co.chop.friends.list.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.chop.friends.databinding.FragmentFriendListBinding
import com.combyne.uikit.base.BaseFragment
import com.combyne.uikit.base.viewmodel.MessageMaster
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendListFragment : BaseFragment<FriendListViewModel>() {

    override val viewModel: FriendListViewModel by viewModel()
    private lateinit var binding: FragmentFriendListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {

    }

    override fun setupObserveData() {
    }

    override fun setupListener() {
    }

    override fun onClick(v: View?) {
        super.onClick(v)
    }

    override fun showMessage(message: MessageMaster) {
        super.showMessage(message)
    }

}