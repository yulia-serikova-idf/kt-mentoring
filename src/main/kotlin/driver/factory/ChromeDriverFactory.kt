package driver.factory

import driver.model.DriverSettings
import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeDriverFactory: DriverFactory {
  override fun setDriver(driver: DriverSettings) {
    WebDriverManager.chromedriver().setup();
  }
}