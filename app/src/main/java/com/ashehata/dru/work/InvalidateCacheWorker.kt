package com.ashehata.dru.work

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ashehata.dru.features.movies.data.local.dao.MoviesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltWorker
class InvalidateCacheWorker @Inject constructor(
    private val moviesDao: MoviesDao,
    appContext: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                Log.i("InvalidateCacheWorker", "doWork: ")
                moviesDao.deleteAll()
                Result.success()
            } catch (e: Exception) {
                Log.i("InvalidateCacheWorker", "Exception: " + e.localizedMessage)
                Result.failure()
            }
        }
    }
}
