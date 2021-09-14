package co.chop.friends.list.di.modules

import co.chop.friends.list.domain.FriendListUseCase
import org.koin.dsl.module

val friendListUseCaseModule = module {
    factory { FriendListUseCase(get()) }
}