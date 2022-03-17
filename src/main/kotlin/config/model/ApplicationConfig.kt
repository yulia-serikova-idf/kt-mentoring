package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private val host: String,
  val user: String,
  val pass: String,
  private val prefixProtocol: ProtocolType
) : TafConfig {

  fun getBaseUrlWithAuthorisation(): String {
    return "${prefixProtocol.prefixName}$user:$pass@$host"
  }

  fun getBaseUrl(): String {
    return "${prefixProtocol.prefixName}$host"
  }
}