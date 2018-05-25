package com.itexico.developer.myapplication.example.ui.views.example

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.itexico.developer.myapplication.R
import com.itexico.developer.myapplication.common.ui.navigation.INavigationManager
import com.itexico.developer.myapplication.common.ui.navigation.INavigationPage
import com.itexico.developer.myapplication.common.ui.views.NavigationControllerBase
import com.itexico.developer.myapplication.example.ui.views.home.HomeFragment
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by rdelgado on 4/25/2018.
 */
open class ExampleNavigationController @Inject constructor
    (activity: MainActivity,
     @Named("example") navigationManager: INavigationManager)
    : NavigationControllerBase(navigationManager) {

    companion object {
        private val TAG = ExampleNavigationController::class.java.simpleName
    }

    private var mFragmentManager: FragmentManager = activity.supportFragmentManager
    private val mContainerId: Int =  R.id.example_container

    init {
        mNavigationManager.navigateToPage(homePage)
    }

    override fun switchFragment(page: INavigationPage) {

        Log.d(TAG, String.format("navigating to page %d", page.getIndex()))
        when (page.getIndex()) {
            ExampleNavigationPage.HOME -> {
                replaceFragment(HomeFragment())
                return
            }
            else -> Log.e(TAG, "Unknown navigation page")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        mFragmentManager
                .beginTransaction()
                .replace(mContainerId, fragment)
                .commitAllowingStateLoss()
    }

    private val homePage: INavigationPage
        get() =  ExampleNavigationPage(ExampleNavigationPage.HOME)

}
