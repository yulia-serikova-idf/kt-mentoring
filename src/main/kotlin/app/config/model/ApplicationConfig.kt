package app.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import config.model.TafConfig
import crm.config.model.CrmUser

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private val host: String,
  val serverHostIp: String,
  val user: String,
  val pass: String,
  private val prefixProtocol: ProtocolType,
  val registrationRoute: String,
  val registrationRouteUi: String,
  val crmStartEndpoint: String,
  val crmLoginEndpoint: String,
  val crmUser: CrmUser
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

  fun getBaseUrl(): String {
    return "${prefixProtocol.prefixName}$host"
  }
}