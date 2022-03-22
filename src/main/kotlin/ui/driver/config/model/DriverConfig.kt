package ui.driver.config.model

import config.model.TafConfig

data class DriverConfig(
  val browser: BrowserType,
  val maximize: Boolean,
  val defaultTimeout: Long,
  val browserSize: String
) : TafConfig