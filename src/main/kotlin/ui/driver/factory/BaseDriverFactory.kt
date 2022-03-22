package ui.driver.factory

import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.browserSize
import com.codeborne.selenide.Configuration.startMaximized
import com.codeborne.selenide.Configuration.timeout
import ui.driver.config.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {
  override fun setDriver(driverConfig: DriverConfig) {
    browser = driverConfig.browser.browserType
    timeout = driverConfig.defaultTimeout
    startMaximized = driverConfig.maximize
    browserSize = driverConfig.browserSize
  }
}