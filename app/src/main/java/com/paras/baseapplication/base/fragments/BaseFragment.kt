package com.paras.baseapplication.base.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.paras.baseapplication.base.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * The Base Activity which will contains common things for each activity.
 */
abstract class BaseFragment : DaggerFragment() {

    // region Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // endregion

}

inline fun <reified T : ViewModel> BaseFragment.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}