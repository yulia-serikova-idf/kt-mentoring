package context.constant.application

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