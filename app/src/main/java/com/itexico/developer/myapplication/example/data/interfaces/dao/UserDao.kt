package com.itexico.developer.myapplication.example.data.interfaces.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.itexico.developer.myapplication.example.data.entities.User
import io.reactivex.Flowable

/**
 * Created by rdelgado on 5/2/2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): Flowable<List<User>>

    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Update(onConflict = REPLACE)
    fun update(user: User)

    @Query("DELETE FROM users")
    fun deleteAll()

    @Delete
    fun delete(user: User)
}