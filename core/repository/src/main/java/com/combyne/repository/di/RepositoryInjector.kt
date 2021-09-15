package com.combyne.repository.di


import com.combyne.repository.db.DatabaseBuilder
import org.koin.dsl.module

object RepositoryInjector {

    fun provideDependencies() = module {

        single { DatabaseBuilder.getInstance(get()) }

    }
}