package com.fiture.mvvm.data.repository

import com.fiture.mvvm.data.source.MainLocalSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

/**
 *
 * Created by caixi on 2022/5/9.
 */
@Singleton
class MainDataRepositoryImpl @Inject constructor(
    private val mainLocalSource: MainLocalSource) : MainDataRepository {

    override suspend fun getMainData() {
        mainLocalSource.getData()
    }

}