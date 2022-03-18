package http.client

import http.model.response.TafResponseBody
import okhttp3.OkHttpClient

interface TafHttpClient {
  var httpClient: OkHttpClient
  fun get(path: String) : TafResponseBody
  fun post()
  fun delete()
}