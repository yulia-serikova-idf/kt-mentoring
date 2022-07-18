package context.constant.application

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

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
  val dbConfig: DbConfig,
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

  fun getMockUrl(): String {
    return ProtocolType.HTTP.prefixName + mockConfig.getUrl()
  }
}