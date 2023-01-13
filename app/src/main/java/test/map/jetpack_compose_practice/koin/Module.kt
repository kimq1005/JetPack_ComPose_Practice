package test.map.jetpack_compose_practice.koin

import android.app.Application
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {
    factory {
        gethttpLogginInterceptor()
    }

    factory {
        getHttpClient(get())
    }

    factory {
        getGsonConvertFactory()
    }

    factory {
        getRetrofit(get(), get())
    }

//    single {
//        getNetworkService(get())
//    }


}

fun gethttpLogginInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun getHttpClient(interceptor: Interceptor) = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

fun getGsonConvertFactory():Converter.Factory = GsonConverterFactory.create()

fun getRetrofit(factory: Converter.Factory, client:OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(factory)
        .client(client)
        .build()

//fun getNetworkService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)