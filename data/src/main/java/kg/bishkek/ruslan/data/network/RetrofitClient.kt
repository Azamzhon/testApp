package kg.bishkek.ruslan.data.network

import android.util.Log
import kg.bishkek.ruslan.data.network.apies.RequestApi
import kg.bishkek.ruslan.data.preferences.UserTokenPreferences
import kg.bishkek.ruslan.data.utils.BASE_URL
import kg.bishkek.ruslan.data.utils.LOGCAT_TEG
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession


/**
 * this method help create retrofit with httpClient
 *
 * @param okHttpClient is OkHttpClient for add to retrofit
 * @return Retrofit
 */
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()


/**
 * this method create OkHttpClient for retrofit
 *
 * @return OkHttpClient
 */
fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
    OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        //.addInterceptor(interceptor)
        .hostnameVerifier {_,_ -> true }
        .build()

/**
 * this method provided interceptor with userToken for OkHttpClient
 *
 * @param tokenPreferences is UserTokenPreferences for get actual userToken
 * @return is Interceptor for OkHttpClient
 */
fun provideUserTokenInterceptor(tokenPreferences: UserTokenPreferences): Interceptor {
    return Interceptor { chain ->
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("token", tokenPreferences.userToken)
            .build()

        // Request customization: add request headers
        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)

        Log.e(LOGCAT_TEG, "provideUserTokenInterceptor: is url: $url")

        val request: Request = requestBuilder.build()
        chain.proceed(request)
    }
}

/**
 * this method provide AuthApi
 *
 * @param retrofit is retrofit for create AuthApi
 * @return AuthApi
 */
fun provideRequestApi(retrofit: Retrofit): RequestApi =
    retrofit.create(RequestApi::class.java)