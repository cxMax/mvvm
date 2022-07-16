package com.fiture.mvvm.utils.extension

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

/**
 *
 * Created by caixi on 2022/6/21.
 */

private const val TAG = "Context.extension"

/**
 * 接收广播
 */
fun Context.receiveBroadcast(vararg actions: String): Flow<Intent> {
    val intentFilter = IntentFilter()
    actions.forEach { action ->
        intentFilter.addAction(action)
    }
    return receiveBroadcast(intentFilter)
}

/**
 * Log
 * @receiver Context
 * @param context Context
 * @return File
 */
fun Context.getLog4aDir(): File? {
    var log = getExternalFilesDir("logs")
    return log?.let {
        File(filesDir, "logs")
    }.also {
        if (it?.exists() == false) {
            it?.mkdir()
        }
    }
}

/**
 * 接收广播
 */
fun Context.receiveBroadcast(intentFilter: IntentFilter) = callbackFlow {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            trySendBlocking(intent)
                .onFailure {
                    Log.w(TAG, it?.stackTraceToString().toString())
                }
        }
    }
    registerReceiver(receiver, intentFilter)
    awaitClose {
        unregisterReceiver(receiver)
    }
}

