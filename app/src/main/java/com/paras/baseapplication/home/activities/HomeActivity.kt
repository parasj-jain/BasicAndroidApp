package com.paras.baseapplication.home.activities

import android.os.Bundle
import com.paras.baseapplication.R
import com.paras.baseapplication.base.activities.BaseActivity
import com.paras.baseapplication.base.activities.getViewModel
import com.paras.baseapplication.home.viewModel.HomeViewModel
import com.paras.baseapplication.home.viewModel.IHomeViewModel

class HomeActivity : BaseActivity() {

    // region Inject

    private val mHomeViewModel: IHomeViewModel by lazy {
        getViewModel<HomeViewModel>()
    }

    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}