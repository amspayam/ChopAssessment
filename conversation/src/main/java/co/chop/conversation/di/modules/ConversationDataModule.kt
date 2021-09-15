package co.chop.conversation.di.modules

import co.chop.conversation.data.ConversationRepositoryImpl
import co.chop.conversation.domain.ConversationRepository
import org.koin.dsl.module

val conversationDataModule = module {
    factory<ConversationRepository> { ConversationRepositoryImpl(get()) }
}
