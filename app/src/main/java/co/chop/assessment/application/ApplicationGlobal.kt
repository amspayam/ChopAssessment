package co.chop.assessment.application

import androidx.multidex.MultiDexApplication
import co.chop.conversation.di.ConversationInjector
import co.chop.friends.list.di.FriendListInjector
import com.combyne.cache.di.CachemanagerInjector
import com.combyne.main.mainactivity.di.MainActivityInjector
import com.combyne.repository.di.RepositoryInjector
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.*

class ApplicationGlobal : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initialKoin()

    }

    private fun initialKoin() {
        startKoin {
            androidLogger(Level.ERROR).androidContext(this@ApplicationGlobal)
                .modules(CachemanagerInjector.provideDependencies())
                .modules(RepositoryInjector.provideDependencies())
                .modules(MainActivityInjector.provideDependencies())
                /*Friends*/
                .modules(FriendListInjector.provideDependencies())
                /*Conversation*/
                .modules(ConversationInjector.provideDependencies())
        }
    }

}