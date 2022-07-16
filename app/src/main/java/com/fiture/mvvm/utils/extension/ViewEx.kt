package com.fiture.mvvm.utils.extension

import android.view.View
import androidx.annotation.CheckResult
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 *
 * Created by caixi on 2022/6/21.
 */
/**
 * 在生命周期 STARTED 时启动
 */
@CheckResult
fun View.launchRepeatOnLifecycleStarted(block: suspend CoroutineScope.() -> Unit): Job? {
    return findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
        lifecycleOwner.lifecycleScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                block()
            }
        }
    }
}

/**
 * 在生命周期 RESUMED 时启动
 */
@CheckResult
fun View.launchRepeatOnLifecycleResumed(block: suspend CoroutineScope.() -> Unit): Job? {
    return findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
        lifecycleOwner.lifecycleScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                block()
            }
        }
    }
}

fun View.getString(@StringRes id: Int): String {
    return resources.getString(id)
}

fun View.getString(@StringRes id: Int, vararg formatArgs: Any): String {
    return resources.getString(id, *formatArgs)
}

/**
 * 使该 View 可以监听 KeyEvent
 */
fun View.enableKeyEvent() {
    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    requestFocusFromTouch()
}
