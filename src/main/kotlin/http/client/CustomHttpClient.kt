package http.client

import context.constant.provider.ApplicationConfigProvider
import http.model.interseptors.ExceptionStatusInterceptor
import http.model.interseptors.ModifyHeaderInterceptor
import http.model.response.TafResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Request.Builder
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class CustomHttpClient : TafHttpClient {
  private val applicationConfig = ApplicationConfigProvider().getConfigData()

  override val httpClient: OkHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
    .addInterceptor(BaseAuthInterseptor(applicationConfig.user, applicationConfig.pass))
    .addInterceptor(ModifyHeaderInterceptor())
    .addInterceptor(ExceptionStatusInterceptor())
    .build()

  override fun get(path: String): TafResponse {
    val request: Request = Builder().get().url(path).build()
    val response: Response = httpClient.newCall(request).execute()
    return TafResponse(response)
  }

  override fun post() {
    TODO("Not yet implemented")
  }

  override fun delete() {
    TODO("Not yet implemented")
  }
}