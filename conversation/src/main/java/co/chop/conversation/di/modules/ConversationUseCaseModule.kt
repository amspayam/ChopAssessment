package co.chop.conversation.di.modules

import co.chop.conversation.domain.ConversationUseCase
import co.chop.conversation.domain.SendMessageUseCase
import org.koin.dsl.module

val conversationUseCaseModule = module {
    factory { ConversationUseCase(get()) }
    factory { SendMessageUseCase(get()) }
}