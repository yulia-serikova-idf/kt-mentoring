package http.retrofit

import http.client.CustomHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
  private var retrofit: Retrofit? = null

  fun getClient(baseUrl: String): Retrofit {
    retrofit = Retrofit.Builder()
      .baseUrl(baseUrl)
      .client(CustomHttpClient().httpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    return retrofit!!
  }
}