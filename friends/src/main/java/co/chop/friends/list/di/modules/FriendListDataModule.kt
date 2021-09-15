package co.chop.friends.list.di.modules

import co.chop.friends.list.data.FriendListRepositoryImpl
import co.chop.friends.list.domain.FriendListRepository
import org.koin.dsl.module

val friendListDataModule = module {
    factory<FriendListRepository> { FriendListRepositoryImpl(get()) }
}
