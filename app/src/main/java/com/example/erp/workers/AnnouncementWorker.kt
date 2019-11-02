package com.example.erp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class AnnouncementWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val appContext = applicationContext
        return try {
            Result.success()
        }catch (throwable:Throwable){
            Result.failure()
        }

    }
}