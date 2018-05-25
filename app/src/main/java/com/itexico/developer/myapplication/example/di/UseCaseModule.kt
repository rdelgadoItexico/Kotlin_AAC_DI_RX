package com.itexico.developer.myapplication.example.di

import com.itexico.developer.myapplication.example.bussines.interfaces.usecases.IUserUseCase
import com.itexico.developer.myapplication.example.bussines.usecases.UserUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by rdelgado on 4/26/2018.
 */
@Module
abstract class UseCaseModule{

    @Binds
    @Singleton
    abstract fun userUseCase(userUseCase: UserUseCase): IUserUseCase
}