package com.itexico.developer.myapplication.common.ui.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by rdelgado on 4/26/2018.
 */
abstract class ActivityBase : FragmentActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var mFragmentDispatchingAndroidInjector : DispatchingAndroidInjector<Fragment>

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentDispatchingAndroidInjector
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}