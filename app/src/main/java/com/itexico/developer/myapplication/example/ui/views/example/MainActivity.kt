package com.itexico.developer.myapplication.example.ui.views.example

import android.os.Bundle
import com.itexico.developer.myapplication.R
import com.itexico.developer.myapplication.common.ui.views.ActivityBase
import javax.inject.Inject

class MainActivity : ActivityBase() {

    @Inject
    lateinit var mNavigationController: ExampleNavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mNavigationController)
        setContentView(R.layout.activity_main)
    }
}