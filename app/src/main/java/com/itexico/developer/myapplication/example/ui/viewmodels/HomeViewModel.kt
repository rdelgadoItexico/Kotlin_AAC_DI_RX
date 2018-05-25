package com.itexico.developer.myapplication.example.ui.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import com.itexico.developer.myapplication.common.rx.SchedulerFacade
import com.itexico.developer.myapplication.common.ui.viewmodels.ViewModelBase
import com.itexico.developer.myapplication.example.bussines.usecases.UserUseCase
import com.itexico.developer.myapplication.example.data.entities.User
import com.mooveit.library.Fakeit

import javax.inject.Inject

/**
 * Created by rdelgado on 4/25/2018.
 */
class HomeViewModel @Inject constructor(private val homeUseCase: UserUseCase): ViewModelBase(){

    private var mUsers = LiveDataReactiveStreams.fromPublisher(homeUseCase.getUsers()
            .subscribeOn(SchedulerFacade.io())
            .observeOn(SchedulerFacade.ui()))

    init {
       Fakeit.init()
    }

    fun getUsersLiveData(): LiveData<List<User>> {
        return mUsers
    }

    fun createUser(){
        val user = User()
        user.name = Fakeit.name().firstName()
        homeUseCase.addUser(user)
    }

    fun deleteAllUsers(){
        homeUseCase.deleteAllUsers()
    }
}