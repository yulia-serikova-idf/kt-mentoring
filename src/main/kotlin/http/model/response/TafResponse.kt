package http.model.response

import config.provider.TafProperties.CONFIG_BASE_PARAM_NAME_COOKIE
import config.provider.TafProperties.CONFIG_COOKIE_DELIMETER
import config.provider.TafProperties.CONFIG_COOKIE_VALUE_DELIMETER
import config.utils.AppConfigReader.getConfigParam
import okhttp3.Response

class TafResponse(private val response: Response) {

  fun getCookieByName(name: String): String? {
    var cookieParamValue: String? = null
    response.headers[getConfigParam(CONFIG_BASE_PARAM_NAME_COOKIE)]?.let { it ->
      val cookieList: List<String> = it.split(getConfigParam(CONFIG_COOKIE_DELIMETER))
      val cookieMap: Map<String, String> =
        cookieList.map { it.split(getConfigParam(CONFIG_COOKIE_VALUE_DELIMETER)) }
          .associate { it.first() to it.last() }
      cookieParamValue = cookieMap[name]
    }
    return cookieParamValue
  }
}