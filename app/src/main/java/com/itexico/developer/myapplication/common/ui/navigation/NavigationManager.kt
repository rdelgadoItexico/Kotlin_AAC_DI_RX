package com.itexico.developer.myapplication.common.ui.navigation

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by rdelgado on 4/25/2018.
 */
class NavigationManager @Inject constructor() : INavigationManager {

    private var mCurrentPage : BehaviorSubject<INavigationPage> = BehaviorSubject.create()
    private var mPreviousPage : INavigationPage? = null

    override fun navigateToPage(page: INavigationPage) {
        mPreviousPage = mCurrentPage.value
        mCurrentPage.onNext(page)
    }

    override fun getCurrentPage(): Observable<INavigationPage> {
        return mCurrentPage
    }
}