package com.itexico.developer.myapplication.example.data.interfaces.repositories

import com.itexico.developer.myapplication.common.data.interfaces.repositories.IRepository
import com.itexico.developer.myapplication.example.data.entities.User
import io.reactivex.Flowable

/**
 * Created by rdelgado on 5/2/2018.
 */
interface IUserRepository : IRepository<User>{
    fun hasUsers(): Flowable<Boolean>
}