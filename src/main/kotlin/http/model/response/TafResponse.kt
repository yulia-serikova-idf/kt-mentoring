package http.model.response

import config.provider.TafProperties.CONFIG_BASE_PARAM_NAME_COOKIE
import config.provider.TafProperties.CONFIG_COOKIE_DELIM
import config.provider.TafProperties.CONFIG_COOKIE_VALUE_DELIM
import config.utils.AppConfigReader.getConfigParam
import okhttp3.Response

class TafResponse(val response: Response) {

  fun getCookieParam(name: String): String? {
    val cookieList: List<String> = response.headers[getConfigParam(CONFIG_BASE_PARAM_NAME_COOKIE)]!!
      .split(getConfigParam(CONFIG_COOKIE_DELIM))
    val cookieMap: Map<String, String> = cookieList.map { it.split(getConfigParam(CONFIG_COOKIE_VALUE_DELIM)) }
      .associate { it.first() to it.last() }
    return cookieMap[name]
  }
}