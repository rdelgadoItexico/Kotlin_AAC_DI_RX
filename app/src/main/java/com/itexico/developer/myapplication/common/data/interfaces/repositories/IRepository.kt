package com.itexico.developer.myapplication.common.data.interfaces.repositories

import io.reactivex.Flowable

/**
 * Created by rdelgado on 5/2/2018.
 */
interface IRepository<T> {

    fun getAll(): Flowable<List<T>>

    fun getItem(id: Int): Flowable<T>

    fun add(item: T)

    fun update(item: T)

    fun remove(item: T)

    fun removeAll()

}