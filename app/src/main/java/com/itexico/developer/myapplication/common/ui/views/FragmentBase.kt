package com.itexico.developer.myapplication.common.ui.views

import android.content.Context
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by rdelgado on 4/26/2018.
 */
abstract class FragmentBase : DialogFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    private var disposables = CompositeDisposable()

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        disposables.clear()
        super.onDetach()
    }

    final override fun supportFragmentInjector(): AndroidInjector<Fragment>{
        return mFragmentInjector
    }

    private fun addDisposable(disposable: Disposable){
        disposables.add(disposable)
    }

}