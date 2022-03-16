package driver.provider

import com.codeborne.selenide.WebDriverRunner
import config.model.BrowserType
import config.model.DriverConfig
import driver.factory.ChromeDriverFactory
import driver.factory.FireFoxDriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class DriverProvider {

  fun define(driverConfig: DriverConfig) {
    when (driverConfig.browser) {
      BrowserType.CHROME -> {
        ChromeDriverFactory().setDriver(driverConfig)
        WebDriverRunner.setWebDriver(ChromeDriver())
      }
      BrowserType.FIREFOX -> {
        FireFoxDriverFactory().setDriver(driverConfig)
        WebDriverRunner.setWebDriver(FirefoxDriver())
      }
    }
  }
}