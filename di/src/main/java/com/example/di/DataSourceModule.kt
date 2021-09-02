package com.example.di

import com.example.data.dataSource.PaintDataSource
import com.example.data_remote.dataSource.PaintDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {

    single<PaintDataSource>{ PaintDataSourceImpl( get() ) }

}