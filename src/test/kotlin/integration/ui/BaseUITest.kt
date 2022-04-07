package integration.ui

import integration.BaseContextManagerTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ui.Browser
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider
import ui.driver.provider.DriverProvider

abstract class BaseUITest : BaseContextManagerTest() {
  lateinit var driverConfig: DriverConfig

  @BeforeEach
  fun init() {
    driverConfig = DriverConfigProvider().getConfigData()
    DriverProvider().define(driverConfig)
  }

  @AfterEach
  fun tearDown() {
    Browser.closeBrowser()
  }
}