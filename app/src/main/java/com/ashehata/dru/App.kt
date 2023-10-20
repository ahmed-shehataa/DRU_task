package com.ashehata.dru

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest.Companion.MIN_PERIODIC_INTERVAL_MILLIS
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.ashehata.dru.worker.InvalidateCacheWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .setWorkerFactory(workerFactory).build()
    }

    override fun onCreate() {
        super.onCreate()
        setupInvalidateCacheWorker()
    }

    private fun setupInvalidateCacheWorker() {
        val timeInterval = if (BuildConfig.DEBUG) MIN_PERIODIC_INTERVAL_MILLIS else 4
        val timeUnit = if (BuildConfig.DEBUG) TimeUnit.MILLISECONDS else TimeUnit.HOURS

        val repeatingRequest = PeriodicWorkRequestBuilder<InvalidateCacheWorker>(
            timeInterval,
            timeUnit
        ).build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            InvalidateCacheWorker.NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}