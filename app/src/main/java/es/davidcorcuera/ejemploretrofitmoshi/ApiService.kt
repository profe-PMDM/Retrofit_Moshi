package es.davidcorcuera.ejemploretrofitmoshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/"

/*
    Getting raw JSON response (without Moshi)
 */

interface ApiService {

    @GET("breeds/image/random")
    suspend fun getImageRandom(): String

    @GET("breeds/list/all")
    suspend fun getAll(): String

}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}

/*
    Using Moshi to convert JSON response
 */

interface ApiServiceMoshi {

    @GET("breeds/image/random")
    suspend fun getImageRandom(): ImageResponse

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitMoshi = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object ApiMoshi {
    val retrofitMoshiService : ApiServiceMoshi by lazy {
        retrofitMoshi.create(ApiServiceMoshi::class.java) }
}

