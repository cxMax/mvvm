package com.fiture.mvvm.ui.component.main.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fiture.mvvm.R
import com.fiture.mvvm.ui.component.main.state.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by caixi on 2022/5/9.
 */
@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private val mainViewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}