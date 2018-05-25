package com.itexico.developer.myapplication.common.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by rdelgado on 4/25/2018.
 */
open class SchedulerFacade {

    companion object {
        fun io(): Scheduler{
            return Schedulers.io()
        }

        fun computation(): Scheduler{
            return Schedulers.computation()
        }

        fun ui(): Scheduler{
            return AndroidSchedulers.mainThread()
        }
    }
}