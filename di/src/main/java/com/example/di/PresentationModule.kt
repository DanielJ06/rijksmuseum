package com.example.di

import com.example.presentation.viewModels.PaintViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { PaintViewModel( get() ) }

}