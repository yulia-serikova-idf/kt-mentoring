package context.constant.application

data class MockConfig(
  val host: String,
  val port: Int
) : TafConfig {
  fun getUrl(): String {
    return "$host:$port"
  }
}