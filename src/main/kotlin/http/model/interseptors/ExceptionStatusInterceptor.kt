package http.model.interseptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ExceptionStatusInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    if ((response.code != 200) && (response.code != 201))
      throw java.lang.IllegalStateException("Not valid http status code [${response.code}] returned in response")
    return response
  }
}