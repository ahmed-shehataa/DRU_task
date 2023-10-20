package com.ashehata.dru.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ashehata.dru.features.movies.data.local.dao.MoviesDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class InvalidateCacheWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val moviesDao: MoviesDao,
) : CoroutineWorker(appContext, workerParams) {

    companion object {
        const val NAME = "InvalidateCacheWorker"
    }

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                Log.i(NAME, "doWork: ")
                if (moviesDao.getMovies().isNotEmpty())
                    moviesDao.deleteAll()
                Result.success()
            } catch (e: Exception) {
                Log.i(NAME, "Exception: " + e.localizedMessage)
                Result.failure()
            }
        }
    }
}
