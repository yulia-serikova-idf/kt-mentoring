package http.model.response

import com.google.gson.Gson
import config.provider.TafProperties.CONFIG_BASE_PARAM_NAME_COOKIE
import config.provider.TafProperties.CONFIG_COOKIE_DELIMETER
import config.provider.TafProperties.CONFIG_COOKIE_VALUE_DELIMETER
import config.utils.AppConfigReader.getConfigParam
import okhttp3.Headers
import okhttp3.ResponseBody

class TafResponse(private val response: retrofit2.Response<ResponseBody>) {

  private fun getHeaders(): Headers {
    return response.headers()
  }

  private fun getCookieHeader(): String? {
    return getHeaders()[getConfigParam(CONFIG_BASE_PARAM_NAME_COOKIE)]
  }

  private fun convertCookieToMap(cookies: String): Map<String, String> {
    return cookies.split(getConfigParam(CONFIG_COOKIE_DELIMETER))
      .map { it.split(getConfigParam(CONFIG_COOKIE_VALUE_DELIMETER)) }
      .associate { it.first() to it.last() }
  }

  fun getCookieByName(name: String): String? {
    var cookieParamValue: String? = null
    getCookieHeader()?.let { it ->
      val cookieMap: Map<String, String> = convertCookieToMap(it)
      cookieParamValue = cookieMap[name]
    }
    return cookieParamValue
  }

  fun <T> convertBodyToObj(bodyType: Class<T>): T {
    return Gson().fromJson(response.body()?.string(), bodyType)
  }
}