package com.itexico.developer.myapplication.common.ui.views

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.itexico.developer.myapplication.common.rx.SchedulerFacade
import com.itexico.developer.myapplication.common.ui.navigation.INavigationManager
import com.itexico.developer.myapplication.common.ui.navigation.INavigationPage
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by rdelgado on 4/25/2018.
 */
abstract class NavigationControllerBase(internal val mNavigationManager: INavigationManager) : LifecycleObserver {

    private val disposables = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener(){
        disposables.add(mNavigationManager.getCurrentPage()
                .subscribeOn(SchedulerFacade.io())
                .observeOn(SchedulerFacade.ui())
                .subscribe(this::switchFragment))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener(){
        disposables.clear()
    }

    internal abstract fun switchFragment(page: INavigationPage)

}

