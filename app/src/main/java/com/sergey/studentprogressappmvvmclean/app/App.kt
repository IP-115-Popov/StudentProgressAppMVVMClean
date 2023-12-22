package com.sergey.studentprogressappmvvmclean.app

import android.app.Application
import com.sergey.studentprogressappmvvmclean.di.appModule
import com.sergey.studentprogressappmvvmclean.di.dataModule
import com.sergey.studentprogressappmvvmclean.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}