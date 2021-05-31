

package com.bignerdranch.android.testone.network


import androidx.viewbinding.BuildConfig
//import com.bignerdranch.android.testone.room.Test
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

private const val BASES_URL =
//    "https://reqres.in/api/"
//    "https://reqres.in"
//"https://reqres.in/api/"
//    "https://reqres.in/api.com"
    "https://android-kotlin-fun-mars-server.appspot.com"


//var  provideOkHttpClient = when(BuildConfig.DEBUG) {
//    BuildConfig.DEBUG-> {
//        OkHttpClient.Builder()
//            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
//                this.level = HttpLoggingInterceptor.Level.BODY
//            })
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .build()
//    }
//    else ->{
//        OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(20, TimeUnit.SECONDS)
//            .build()
//    }
//}

var provideOkHttpClient = if (BuildConfig.DEBUG) {
    OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()
} else {
    OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()
}
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASES_URL)
    .client(provideOkHttpClient)
    .build()

interface TestApiServise{
//    @GET("users?page=2")
@GET("photos")
//@GET("users?page=2")
    suspend fun getDataUser(): List<UseData>
}
object TestApi{
    val retrofitServise: TestApiServise by lazy {
        retrofit.create(TestApiServise::class.java)
    }
}


//fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
//    OkHttpClient.Builder()
//        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
//            this.level = HttpLoggingInterceptor.Level.BODY
//        })
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .readTimeout(20, TimeUnit.SECONDS)
//        .writeTimeout(20, TimeUnit.SECONDS)
//        .build()
//} else {
//    OkHttpClient.Builder()
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .readTimeout(20, TimeUnit.SECONDS)
//        .writeTimeout(20, TimeUnit.SECONDS)
//        .build()
//}