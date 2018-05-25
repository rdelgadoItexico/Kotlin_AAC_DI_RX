package com.itexico.developer.myapplication.common.ui.viewmodels

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by rdelgado on 4/25/2018.
 */

abstract class ViewModelBase: ViewModel(){
    private val mDisposables = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        mDisposables.add(disposable)
    }

    @Override
    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }
}