package http.client

import http.model.response.TafResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface TafHttpClient {
  val httpClient: OkHttpClient
  val logger: HttpLoggingInterceptor
  fun get(path: String): TafResponse
  fun post()
  fun delete()
}