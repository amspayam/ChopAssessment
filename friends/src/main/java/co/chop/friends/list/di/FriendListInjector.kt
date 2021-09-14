package co.chop.friends.list.di

import co.chop.friends.list.di.modules.friendListDataModule
import co.chop.friends.list.di.modules.friendListPresentationModule
import co.chop.friends.list.di.modules.friendListUseCaseModule
import org.koin.core.module.Module

object FriendListInjector {
    fun provideDependencies(): List<Module> {
        return listOf(
            friendListPresentationModule,
            friendListUseCaseModule,
            friendListDataModule
        )
    }
}