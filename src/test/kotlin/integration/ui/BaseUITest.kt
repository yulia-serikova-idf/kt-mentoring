package integration.ui

import config.model.ApplicationConfig
import config.model.DriverConfig
import config.provider.ApplicationConfigProvider
import config.provider.DriverConfigProvider
import driver.provider.DriverProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ui.Browser

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