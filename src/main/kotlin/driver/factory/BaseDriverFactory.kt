package driver.factory

import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.timeout
import config.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {
  override fun setDriver(driverConfig: DriverConfig) {
    browser = driverConfig.browser.browserType
    timeout = driverConfig.defaultTimeout
  }
}