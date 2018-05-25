package com.itexico.developer.myapplication.example.ui.views.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rdelgado on 4/27/2018.
 */
@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun fragment(): HomeFragment

}