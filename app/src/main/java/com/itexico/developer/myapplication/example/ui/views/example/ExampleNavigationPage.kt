package com.itexico.developer.myapplication.example.ui.views.example

import android.support.annotation.IntDef
import com.itexico.developer.myapplication.common.ui.navigation.INavigationPage

/**
 * Created by rdelgado on 4/25/2018.
 */
class ExampleNavigationPage(@ExamplePage private var index: Int?) : INavigationPage {

    companion object {
        const val HOME = 0
        private val TAG = ExampleNavigationPage::class.java.simpleName
    }

    override fun getIndex(): Int? {
        return index
    }

    override fun toString(): String {
        return String.format("%s_%d", TAG, getIndex())
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(HOME)
    annotation class ExamplePage
}