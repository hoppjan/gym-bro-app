package de.janhopp.gymbro

import android.app.Application
import de.janhopp.gymbro.db.UserRepository
import de.janhopp.gymbro.db.createDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class GymBroApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GymBroApp)
            modules(
                module {
                    singleOf(::createDatabase)
                    singleOf(::UserRepository)
                }
            )
        }
    }
}
