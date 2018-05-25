package com.itexico.developer.myapplication.example.data.databases

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.itexico.developer.myapplication.example.data.converters.TimestampConverter
import com.itexico.developer.myapplication.example.data.entities.User
import com.itexico.developer.myapplication.example.data.interfaces.dao.UserDao

/**
 * Created by rdelgado on 5/2/2018.
 */
@Database(entities = [User::class], version = ExampleDatabase.VERSION, exportSchema = false )
@TypeConverters(TimestampConverter::class)
abstract class ExampleDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun userDao(): UserDao
}