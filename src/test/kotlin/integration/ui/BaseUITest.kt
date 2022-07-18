package integration.ui

import integration.BaseContextManagerTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import services.ui.CrmUiOperationService
import ui.Browser
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider
import ui.driver.provider.DriverProvider

abstract class BaseUITest : BaseContextManagerTest() {
  lateinit var driverConfig: DriverConfig
  lateinit var crmUiOperationService: CrmUiOperationService

  @BeforeEach
  fun init() {
    crmUiOperationService = CrmUiOperationService()
    driverConfig = DriverConfigProvider().getConfigData()
    DriverProvider().define(driverConfig)
  }

  @AfterEach
  fun tearDown() {
    Browser.closeBrowser()
  }
}