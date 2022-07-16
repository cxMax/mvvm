package com.fiture.mvvm.ui.component.main.state

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiture.mvvm.data.repository.MainDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * Created by caixi on 2022/5/9.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val application: Application,
    private val mainDataRepository: MainDataRepository,
) : ViewModel() {

    init {
        collect()
    }

    private fun collect() {
        viewModelScope.launch {

        }
    }

}