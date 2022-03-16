package config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DriverConfig  (
  var browser: BrowserType,
  var maximize: Boolean,
  var defaultTimeout: Long
) :Config()