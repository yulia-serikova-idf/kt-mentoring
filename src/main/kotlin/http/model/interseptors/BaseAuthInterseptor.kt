package http.client

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BaseAuthInterseptor(user: String, password: String) : Interceptor {

  var credentials: String

  init {
    credentials = Credentials.basic(user, password)
  }

  override fun intercept(chain: Interceptor.Chain): Response {

    val request: Request = chain.request()
    val authenticatedRequest = request.newBuilder()
      .header("Authorization", credentials).build()
    return chain.proceed(authenticatedRequest)
  }
}