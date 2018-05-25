package com.itexico.developer.myapplication.example.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.itexico.developer.myapplication.common.ui.viewmodels.ViewModelFactory
import com.itexico.developer.myapplication.common.ui.viewmodels.ViewModelKey
import com.itexico.developer.myapplication.example.ui.viewmodels.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by rdelgado on 4/26/2018.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

}