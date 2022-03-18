package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DriverConfig(
  val browser: BrowserType,
  val maximize: Boolean,
  val defaultTimeout: Long,
  val browserSize: String
) : TafConfig