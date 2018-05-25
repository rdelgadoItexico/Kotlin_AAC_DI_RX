package com.itexico.developer.myapplication.example.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.itexico.developer.myapplication.example.bussines.ExampleApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rdelgado on 4/26/2018.
 */
@Module
abstract class AppModule {

    @Module
    companion object{

        @Provides
        @Singleton
        fun provideSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences("ExamplePreferences", Context.MODE_PRIVATE)
        }
    }

    @Binds
    @Singleton
    abstract fun application(app: ExampleApplication): Application
}