package driver.model

import config.model.BrowserType

data class DriverSettings (
  var browserType: BrowserType,
  var browserSize: String,
  var defaultTimeout: Long
) {


}