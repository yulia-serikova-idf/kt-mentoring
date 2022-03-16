package driver.factory

import config.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FireFoxDriverFactory : BaseDriverFactory() {
  override fun setDriver(driverConfig: DriverConfig) {
    super.setDriver(driverConfig)
    WebDriverManager.firefoxdriver().setup()
  }
}