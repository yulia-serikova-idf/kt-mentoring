package app.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import config.model.TafConfig

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private val host: String,
  val user: String,
  val pass: String,
  private val prefixProtocol: ProtocolType,
  val registrationRoute: String
) : TafConfig {

  fun getBaseUrlWithAuthorisation(): String {
    return "${prefixProtocol.prefixName}$user:$pass@$host"
  }

  fun getRegistrationRoutePath(): String {
    return getBaseUrlWithAuthorisation() + registrationRoute
  }

  fun setRoute(route: String): String {
    return getBaseUrlWithAuthorisation() + route
  }
}