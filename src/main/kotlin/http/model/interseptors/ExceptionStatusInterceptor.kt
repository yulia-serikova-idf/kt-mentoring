package http.model.interseptors

import config.provider.TafProperties
import config.utils.AppConfigReader
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ExceptionStatusInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    if ((response.code != 200) && (response.code != 201))
      throw Exception(AppConfigReader.getConfigParam(TafProperties.CONFIG_MYEXCEPT_MESSAGE) + response.code)
    return response
  }
}