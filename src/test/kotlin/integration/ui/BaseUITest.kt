package integration.ui

import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.dynamic.TafDynamicContext
import context.dynamic.TafDynamicContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import ui.Browser
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider
import ui.driver.provider.DriverProvider

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest {
  lateinit var driverConfig: DriverConfig

  @BeforeAll
  fun createContext() {
    TafStaticContextHolder.setContext(TafStaticContext())
    TafDynamicContextHolder.setContext(TafDynamicContext())
  }

  @BeforeEach
  fun init() {
    driverConfig = DriverConfigProvider().getConfigData()
    DriverProvider().define(driverConfig)
  }

  @AfterEach
  fun tearDown() {
    Browser.closeBrowser()
  }

  @AfterAll
  fun cleanup() {
    TafStaticContextHolder.clearContext()
    TafDynamicContextHolder.clearContext()
  }
}