package dsm2017.com.sns.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Connect {
    lateinit var api: API

    val url = "http://35.190.237.101:3333/"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(API::class.java)
    }


}