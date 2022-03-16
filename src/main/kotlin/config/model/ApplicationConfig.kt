package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  private val host: String,
  var user: String,
  var pass: String,
  private var prefix: String = "http://",
  @JsonProperty("driver") var driverType: DriverType
) : Config() {

  fun getAuthLink() : String {
    return "$prefix$user:$pass@$host"
  }
  fun getLink(): String {
    return "$prefix$host"
  }

}