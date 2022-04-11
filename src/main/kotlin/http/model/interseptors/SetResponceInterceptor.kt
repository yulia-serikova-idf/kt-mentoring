package http.model.interseptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class SetResponceInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    val respBody = response.body?.string()?.toResponseBody()
//    respBody.let{
//      TafDynamicContextHolder.getContext().sessionContext.contextResponse =
//        TafResponse(response.newBuilder().body(respBody).build())
//    }
    return response!!
  }
}