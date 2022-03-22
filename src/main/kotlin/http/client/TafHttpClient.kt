package http.client

import app.config.model.ApplicationConfig
import app.config.provider.ApplicationConfigProvider
import http.model.response.TafResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface TafHttpClient {
  val httpClient: OkHttpClient
  val applicationConfig: ApplicationConfig
    get() = ApplicationConfigProvider().getConfigData()
  val logger: HttpLoggingInterceptor
  fun get(path: String): TafResponse
  fun post()
  fun delete()
}