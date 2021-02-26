package kg.bishkek.ruslan.testapp

import android.app.Application
import com.geektech.registration.ui.service_locator.registrationModule
import kg.bishkek.ruslan.data.servise_lacator.dataModule
import kg.bishkek.ruslan.testapp.content_provider.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()

            modules(listOf(
                mainModule,
                dataModule,
                registrationModule
            ))
        }
    }
}