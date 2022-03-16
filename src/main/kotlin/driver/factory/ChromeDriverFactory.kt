package driver.factory

import config.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverFactory : BaseDriverFactory() {
  override fun setDriver(driverConfig: DriverConfig) {
    super.setDriver(driverConfig)
    WebDriverManager.chromedriver().setup()
  }
}