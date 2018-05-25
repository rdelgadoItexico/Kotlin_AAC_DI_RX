package com.itexico.developer.myapplication.example.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.*


/**
 * Created by rdelgado on 5/2/2018.
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "name") var name: String,
        //@TypeConverters(TimestampConverter::class)
        @ColumnInfo(name = "date") var timestamp: Date
){
    @Ignore
    constructor():this(null, "", Date(0))
}