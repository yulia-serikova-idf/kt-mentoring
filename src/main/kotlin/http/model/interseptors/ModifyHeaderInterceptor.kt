package http.model.interseptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * simple modify headers
 */
class ModifyHeaderInterceptor() : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request().newBuilder()
      .header("User-Agent", " Mozilla/5.0 ")
      .build()
    return chain.proceed(request)
  }
}