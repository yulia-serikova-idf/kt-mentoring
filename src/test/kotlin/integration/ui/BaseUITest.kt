package integration.ui

import app.config.model.ApplicationConfig
import app.config.provider.ApplicationConfigProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ui.Browser
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider
import ui.driver.provider.DriverProvider

abstract class BaseUITest {

  lateinit var applicationConfig: ApplicationConfig
  lateinit var driverConfig: DriverConfig

  @BeforeEach
  fun init() {
    applicationConfig = ApplicationConfigProvider().getConfigData()
    driverConfig = DriverConfigProvider().getConfigData()
    DriverProvider().define(driverConfig)
  }

  @AfterEach
  fun tearDown() {
    Browser.closeBrowser()
  }
}