package co.chop.conversation.di.modules

import co.chop.conversation.presenter.ConversationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val conversationPresentationModule = module {
    viewModel { ConversationViewModel(get()) }
}