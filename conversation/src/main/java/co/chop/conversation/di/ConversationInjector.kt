package co.chop.conversation.di

import co.chop.conversation.di.modules.conversationDataModule
import co.chop.conversation.di.modules.conversationPresentationModule
import co.chop.conversation.di.modules.conversationUseCaseModule
import org.koin.core.module.Module

object ConversationInjector {
    fun provideDependencies(): List<Module> {
        return listOf(
            conversationPresentationModule,
            conversationUseCaseModule,
            conversationDataModule
        )
    }
}