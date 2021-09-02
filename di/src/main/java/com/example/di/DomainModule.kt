package com.example.di

import com.example.domain.useCases.paints.GetPaints
import com.example.domain.utils.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {

    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        GetPaints(scope, paintRepository = get())
    }

}