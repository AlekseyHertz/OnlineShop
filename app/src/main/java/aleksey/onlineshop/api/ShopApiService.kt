package aleksey.onlineshop.api

import aleksey.onlineshop.dto.Shop
import androidx.media3.datasource.okhttp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path



const val BASE_URL = "${BuildConfig.DEBUG}"

private val logging = HttpLoggingInterceptor().apply {
    if (BuildConfig.DEBUG) {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()


interface ShopApiService {
    @GET("shops")
    fun getAll(): Response<List<Shop>>

    @POST("shops/{id}/likes")
    fun likeById(@Path("id") id: Long): Response<Shop>

    @DELETE("shops/{id}/likes")
    fun dislikeById(@Path("id") id: Long): Response<Shop>
}


object ShopApi {
    val service: ShopApiService by lazy {
        retrofit.create(ShopApiService::class.java)
    }
}