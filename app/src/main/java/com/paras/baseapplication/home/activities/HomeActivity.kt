package com.paras.baseapplication.home.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.paras.baseapplication.R
import com.paras.baseapplication.home.viewModel.HomeViewModel
import com.paras.baseapplication.home.viewModel.IHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : FragmentActivity() {

    // region Inject

    private val mHomeViewModel: IHomeViewModel by viewModels<HomeViewModel>()

    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}