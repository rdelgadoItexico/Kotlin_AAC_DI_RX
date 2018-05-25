package com.itexico.developer.myapplication.example.bussines.usecases

import com.itexico.developer.myapplication.example.bussines.interfaces.usecases.IUserUseCase
import com.itexico.developer.myapplication.example.data.entities.User
import com.itexico.developer.myapplication.example.data.interfaces.repositories.IUserRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rdelgado on 5/2/2018.
 */
@Singleton
class UserUseCase @Inject constructor(private val repository: IUserRepository): IUserUseCase {

    override fun getUsers(): Flowable<List<User>> {
        return repository.getAll()
    }

    override fun hasUsers(): Flowable<Boolean> {
        return repository.hasUsers()
    }

    override fun addUser(user: User) {
        repository.add(user)
    }

    override fun deleteUser(user: User){
        repository.remove(user)
    }

    override fun deleteAllUsers(){
        repository.removeAll()
    }

}