package com.itexico.developer.myapplication.example.data.repositories

import com.itexico.developer.myapplication.common.rx.SchedulerFacade
import com.itexico.developer.myapplication.example.data.databases.ExampleDatabase
import com.itexico.developer.myapplication.example.data.entities.User
import com.itexico.developer.myapplication.example.data.interfaces.repositories.IUserRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by rdelgado on 5/2/2018.
 */
class UserRoomRepository @Inject constructor(exampleDatabase: ExampleDatabase) : IUserRepository {

    private val userDao = exampleDatabase.userDao()

    override fun hasUsers(): Flowable<Boolean> {
        return userDao.getAll().map({ errors -> errors.isNotEmpty() })
    }

    override fun getAll(): Flowable<List<User>> {
        return userDao.getAll()
    }

    override fun getItem(id: Int): Flowable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(item: User) {
        Observable.just<Any>(userDao)
                .subscribeOn(SchedulerFacade.io())
                .subscribe { _ -> userDao.insert(item) }
    }

    override fun update(item: User) {
        Observable.just<Any>(userDao)
                .subscribeOn(SchedulerFacade.io())
                .subscribe { _ -> userDao.update(item) }
    }

    override fun remove(item: User) {
        Observable.just<Any>(userDao)
                .subscribeOn(SchedulerFacade.io())
                .subscribe { _ -> userDao.delete(item) }
    }

    override fun removeAll() {
        Observable.just<Any>(userDao)
                .subscribeOn(SchedulerFacade.io())
                .subscribe { _ -> userDao.deleteAll() }
    }

}