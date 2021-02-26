package kg.bishkek.ruslan.data.servise_lacator

import kg.bishkek.ruslan.data.impl.RepositoryImpl
import kg.bishkek.ruslan.data.models.RepositoryApi
import kg.bishkek.ruslan.data.network.provideOkHttpClient
import kg.bishkek.ruslan.data.network.provideRequestApi
import kg.bishkek.ruslan.data.network.provideRetrofit
import kg.bishkek.ruslan.data.network.provideUserTokenInterceptor
import kg.bishkek.ruslan.data.preferences.IdPreferences
import kg.bishkek.ruslan.data.preferences.SharedPreferencesProvider
import kg.bishkek.ruslan.data.preferences.UserTokenPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * this is a module for Coin ServiceLocator
 */
val dataModule = module {
    single { SharedPreferencesProvider(androidContext()).provideSharedPreferences() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { RepositoryImpl(get(), get()) as RepositoryApi}
    single { UserTokenPreferences(get()) }

    factory { provideRequestApi(get()) }
    factory { provideUserTokenInterceptor(get()) }
    factory { IdPreferences(get()) }
}