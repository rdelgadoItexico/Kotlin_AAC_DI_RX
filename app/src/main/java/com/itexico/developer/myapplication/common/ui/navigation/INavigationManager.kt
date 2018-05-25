package com.itexico.developer.myapplication.common.ui.navigation

import io.reactivex.Observable

/**
 * Created by rdelgado on 4/25/2018.
 */
interface INavigationManager {

    fun navigateToPage(page: INavigationPage)

    fun getCurrentPage() : Observable<INavigationPage>

}