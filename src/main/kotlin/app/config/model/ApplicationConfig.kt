package app.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import config.model.TafConfig
import crm.config.model.CrmUser
import mock.config.model.MockConfig

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private var host: String,
  val serverHostIp: String,
  val user: String,
  val pass: String,
  private var prefixProtocol: ProtocolType,
  val registrationRoute: String,
  val registrationRouteUi: String,
  val crmStartEndpoint: String,
  val crmLoginEndpoint: String,
  var crmUser: CrmUser,
  var mockConfig: MockConfig
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

  fun clone(): ApplicationConfig {
    val cloneObj = this.copy()
    cloneObj.crmUser = this.crmUser.copy()
    cloneObj.mockConfig = this.mockConfig.copy()
    return cloneObj
  }

  fun getMockAppConfig(): ApplicationConfig {
    return this.clone().apply {
      prefixProtocol = ProtocolType.HTTP
      host = mockConfig.host + ":" + mockConfig.port
    }
  }
}