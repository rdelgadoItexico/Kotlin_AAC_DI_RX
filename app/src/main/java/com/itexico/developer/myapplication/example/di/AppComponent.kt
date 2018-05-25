package com.itexico.developer.myapplication.example.di

import com.itexico.developer.myapplication.example.bussines.ExampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rdelgado on 4/25/2018.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    ViewModelModule::class,
    UseCaseModule::class,
    DataAccessModule::class
])

interface AppComponent{

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: ExampleApplication) : Builder

        fun build(): AppComponent
    }

    fun inject (app: ExampleApplication)
}