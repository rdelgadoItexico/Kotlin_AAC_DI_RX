package com.itexico.developer.myapplication.example.ui.views.example

import android.app.Activity
import com.itexico.developer.myapplication.example.ui.views.home.HomeFragmentModule
import dagger.Binds
import dagger.Module

/**
 * Created by rdelgado on 4/27/2018.
 */
@Module(includes = [HomeFragmentModule::class])
abstract class ExampleActivityModule {

    @Binds
    abstract fun bindsActivity(activity: MainActivity): Activity
}