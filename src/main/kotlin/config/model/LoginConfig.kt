package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LoginConfig(
  val host: String? = null,
  var user: String? = null,
  var pass: String? = null,
  @JsonProperty("driver") var driverType: DriverTypes? = null
) {
}