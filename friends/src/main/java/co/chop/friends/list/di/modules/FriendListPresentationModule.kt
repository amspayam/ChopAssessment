package co.chop.friends.list.di.modules

import co.chop.friends.list.presenter.FriendListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val friendListPresentationModule = module {
    viewModel { FriendListViewModel(get()) }
}