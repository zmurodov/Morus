package uz.morus.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Android Developer on 29.03.2018.
 */
class ApiFactory {
    companion object {

        private val BASE_URL = "http://morus.uz/api/"
        private var okClient: OkHttpClient? = null
        private var morusService: MorusService? = null

        fun getMorus(): MorusService {
            var service = morusService
            if (service == null) {
                synchronized(ApiFactory::class.java) {
                    morusService = buildSeller().create(MorusService::class.java)
                    service = morusService
                }
            }
            return service!!
        }


        private fun buildSeller(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        private fun getClient(): OkHttpClient {
            var c: OkHttpClient? = okClient
            if (c == null) {
                synchronized(ApiFactory::class.java) {
                    c = okClient
                    if (c == null) {
                        okClient = buildClient()
                        c = okClient
                    }
                }
            }
            return c!!
        }

        private fun buildClient(): OkHttpClient {
            val interceptor = Interceptor { chain ->
                val request = chain.request()
                request.newBuilder().addHeader("Cache-Control", "no-cache")
                chain.proceed(request)
            }
            return OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(interceptor)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout((60 / 2).toLong(), TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .cache(null)
                    .build()
        }
    }

}
