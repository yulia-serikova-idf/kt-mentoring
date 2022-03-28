package http.client

import http.model.response.TafResponse
import okhttp3.OkHttpClient

interface TafHttpClient {
  val httpClient: OkHttpClient
  fun get(path: String): TafResponse
  fun post()
  fun delete()
}