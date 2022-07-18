package http.model.interseptors

import context.dynamic.TafDynamicContextHolder
import http.model.response.TafResponse
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class SetToContextResponseInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    TafDynamicContextHolder.getContext().sessionContext.contextResponse = TafResponse(response)
    return response
  }
}