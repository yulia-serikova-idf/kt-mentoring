package http.model.response

import config.provider.TafProperties.CONFIG_BASE_PARAM_NAME_COOKIE
import config.provider.TafProperties.CONFIG_COOKIE_DELIMETER
import config.provider.TafProperties.CONFIG_COOKIE_VALUE_DELIMETER
import config.utils.AppConfigReader.getConfigParam
import okhttp3.Headers
import okhttp3.Response

class TafResponse(private val response: Response) {
  private fun getHeaders(response: Response): Headers {
    return response.headers
  }

  private fun getCookieHeader(): String? {
    return getHeaders(response)[getConfigParam(CONFIG_BASE_PARAM_NAME_COOKIE)]
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
}