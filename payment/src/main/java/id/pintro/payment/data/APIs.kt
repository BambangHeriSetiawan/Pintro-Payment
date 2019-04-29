package id.pintro.payment.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import id.pintro.payment.data.model.channels.ResponsePaymentChannels
import io.reactivex.Observable
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by simx on 29,April,2019
 */
interface APIs {

    @Headers("Accept: application/json", "Content-type: application/json")
    @GET(ApiEndpoints.url_payment_channels)
    fun channels(@Header("Authorization") token:String,
                        @Query("client_id") clientId:Int,
                        @Query("app_id") appId:Int
    ): Observable<ResponsePaymentChannels>
    object Factory {
        /**
         * Config GSON
         * @return
         */
        private val gson: Gson
            get() {
                val gsonBuilder = GsonBuilder()
                gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                return gsonBuilder.create()
            }

        fun create(base_url: String): APIs {
            return getRetrofitConfig(base_url).create(APIs::class.java)
        }

        /**
         * Config retrofilt
         * @return
         */
        private fun getRetrofitConfig(base_url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client())
                .build()
        }

        /**
         * Config OkhttpClient and interceptions
         * @return
         */
        private fun client(): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )

                .build()
        }

    }
}