package co.chop.conversation.di.modules

import co.chop.conversation.domain.ConversationUseCase
import org.koin.dsl.module

val fconversationUseCaseModule = module {
    factory { ConversationUseCase(get()) }
}