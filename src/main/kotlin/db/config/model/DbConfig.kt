package db.config.model

import config.model.TafConfig

data class DbConfig(
  val url: String,
  val user: String,
  val port: Int,
  val password: String,
  val schema: String,
) : TafConfig {

  fun getConnectionUrlWithSchema(): String {
    return "$url:$port/$schema"
  }
}