package com.itexico.developer.myapplication.example.di

import com.itexico.developer.myapplication.common.ui.navigation.INavigationManager
import com.itexico.developer.myapplication.common.ui.navigation.NavigationManager
import com.itexico.developer.myapplication.example.ui.views.example.ExampleActivityModule
import com.itexico.developer.myapplication.example.ui.views.example.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by rdelgado on 4/26/2018.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ExampleActivityModule::class])
    abstract fun bindMainActivity (): MainActivity

    @Module
    companion object {
        @Provides
        @Named("example")
        @Singleton
        @JvmStatic
        fun bindsNavigationManager(navigationManager: NavigationManager): INavigationManager {
            return navigationManager
        }
    }
}