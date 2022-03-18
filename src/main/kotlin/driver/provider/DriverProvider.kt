package driver.provider

import config.model.BrowserType
import config.model.DriverConfig
import driver.factory.ChromeDriverFactory
import driver.factory.FirefoxDriverFactory

class DriverProvider {

  fun define(driverConfig: DriverConfig) {
    val driverFactory = when (driverConfig.browser) {
      BrowserType.CHROME -> ChromeDriverFactory()
      BrowserType.FIREFOX -> FirefoxDriverFactory()
    }
    driverFactory.setDriver(driverConfig)
  }
}