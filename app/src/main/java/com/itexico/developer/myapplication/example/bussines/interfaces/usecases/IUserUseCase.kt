package com.itexico.developer.myapplication.example.bussines.interfaces.usecases

import com.itexico.developer.myapplication.example.data.entities.User
import io.reactivex.Flowable

/**
 * Created by rdelgado on 5/2/2018.
 */
interface IUserUseCase {

    fun hasUsers(): Flowable<Boolean>

    fun addUser(user: User)

    fun getUsers(): Flowable<List<User>>

    fun deleteUser(user: User)

    fun deleteAllUsers()
}