package co.chop.friends.list.di

import co.chop.friends.list.di.modules.friendListPresentationModule
import org.koin.core.module.Module

object FriendListInjector {
    fun provideDependencies(): List<Module> {
        return listOf(
            friendListPresentationModule,
        )
    }
}