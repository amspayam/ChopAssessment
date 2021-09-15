package co.chop.assessment.repository.di


import co.chop.assessment.repository.db.DatabaseBuilder
import org.koin.dsl.module

object RepositoryInjector {

    fun provideDependencies() = module {

        single { DatabaseBuilder.getInstance(get()) }

    }
}