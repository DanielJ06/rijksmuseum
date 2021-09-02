package com.example.di

import com.example.data.repository.PaintRepositoryImpl
import com.example.domain.repository.PaintRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<PaintRepository> { PaintRepositoryImpl( get() ) }

}