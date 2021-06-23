package com.paras.baseapplication.base.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * The Base Activity which will contains common things for each activity.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    // region Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // endregion

}

inline fun <reified T : ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}