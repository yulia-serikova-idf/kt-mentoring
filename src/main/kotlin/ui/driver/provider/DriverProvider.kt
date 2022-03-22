package ui.driver.provider

import ui.driver.config.model.BrowserType
import ui.driver.config.model.DriverConfig
import ui.driver.factory.ChromeDriverFactory
import ui.driver.factory.FirefoxDriverFactory

class DriverProvider {

  fun define(driverConfig: DriverConfig) {
    val driverFactory = when (driverConfig.browser) {
      BrowserType.CHROME -> ChromeDriverFactory()
      BrowserType.FIREFOX -> FirefoxDriverFactory()
    }
    driverFactory.setDriver(driverConfig)
  }
}