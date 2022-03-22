package ui.driver.factory

import io.github.bonigarcia.wdm.WebDriverManager
import ui.driver.config.model.DriverConfig

class FirefoxDriverFactory : BaseDriverFactory() {
  override fun setDriver(driverConfig: DriverConfig) {
    super.setDriver(driverConfig)
    WebDriverManager.firefoxdriver().setup()
  }
}