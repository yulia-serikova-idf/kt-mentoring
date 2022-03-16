package com.ui

import com.codeborne.selenide.WebDriverRunner
import config.model.ApplicationConfig
import config.provider.ConfigProvider
import config.provider.DriverConfigProvider
import driver.provider.DriverProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class BaseUITest {

  var applicationConfig: ApplicationConfig = ConfigProvider().getConfigData()
  var driverConfig = DriverConfigProvider().getConfigData()

  /**
   * or before??
   */
  @BeforeEach
  fun init() {
    DriverProvider().define(driverConfig)
    WebDriverRunner.getWebDriver().get(applicationConfig.getLink())
  }

  @AfterEach
  fun tearDown() {
    WebDriverRunner.closeWebDriver()
  }
}