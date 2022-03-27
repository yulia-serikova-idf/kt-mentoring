package app.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import config.model.TafConfig
import db.config.model.DbConfig

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private val host: String,
  val user: String,
  val pass: String,
  private val prefixProtocol: ProtocolType,
  val dbConfig: DbConfig
) : TafConfig {

  fun getBaseUrlWithAuthorisation(): String {
    return "${prefixProtocol.prefixName}$user:$pass@$host"
  }

  fun getBaseUrl(): String {
    return "${prefixProtocol.prefixName}$host"
  }
}