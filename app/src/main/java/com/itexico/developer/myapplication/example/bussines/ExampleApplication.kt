package com.itexico.developer.myapplication.example.bussines

import android.app.Activity
import android.app.Application
import com.itexico.developer.myapplication.example.bussines.interfaces.IExampleApplication
import com.itexico.developer.myapplication.example.di.DaggerAppComponent
import com.itexico.developer.myapplication.example.utils.Constants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by rdelgado on 4/26/2018.
 */
class ExampleApplication : Application(), IExampleApplication {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        deleteDatabase(Constants.DATABASE_FILENAME)
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}