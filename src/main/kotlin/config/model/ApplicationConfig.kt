package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
  val host: String,
  var user: String,
  var pass: String,
  @JsonProperty("driver") var driverType: DriverType
) {
}