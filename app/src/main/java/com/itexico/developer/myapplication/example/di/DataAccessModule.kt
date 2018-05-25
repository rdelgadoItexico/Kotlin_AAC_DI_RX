package com.itexico.developer.myapplication.example.di

import android.app.Application
import android.arch.persistence.room.Room
import com.itexico.developer.myapplication.example.data.databases.ExampleDatabase
import com.itexico.developer.myapplication.example.data.interfaces.repositories.IUserRepository
import com.itexico.developer.myapplication.example.data.repositories.UserRoomRepository
import com.itexico.developer.myapplication.example.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rdelgado on 5/2/2018.
 */
@Module
abstract class DataAccessModule {

    /*@Provides
    @Singleton
    internal fun provideRoomDatabase(application: Application): ExampleDatabase {
        return Room.databaseBuilder(application, ExampleDatabase::class.java, Constants.DATABASE_FILENAME).build()
    }*/

    @Module
    companion object{
        @Provides
        @Singleton
        @JvmStatic
        fun provideRoomDatabase(application: Application): ExampleDatabase {
            return Room.databaseBuilder(application, ExampleDatabase::class.java, Constants.DATABASE_FILENAME).build()
        }
    }

    @Binds
    @Singleton
    internal abstract fun errorRepository(repository: UserRoomRepository): IUserRepository
}