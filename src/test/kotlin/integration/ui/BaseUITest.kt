package integration.ui

import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.constant.application.ApplicationConfig
import context.contextApplicationConfig
import context.dynamic.TafDynamicContext
import context.dynamic.TafDynamicContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import services.api.CrmApiOperationService
import ui.Browser
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider
import ui.driver.provider.DriverProvider

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest {

  lateinit var applicationConfig: ApplicationConfig
  lateinit var driverConfig: DriverConfig

  @BeforeAll
  fun createContext() {
    TafStaticContextHolder.setContext(TafStaticContext())
    TafDynamicContextHolder.setContext(TafDynamicContext())
  }

  @BeforeEach
  fun init() {
    applicationConfig = contextApplicationConfig()
    CrmApiOperationService(applicationConfig.getBaseUrlWithAuthorisation(), applicationConfig.crmUser)
      .getJSessionAuthorisationCookie()
    driverConfig = DriverConfigProvider().getConfigData()
    DriverProvider().define(driverConfig)
  }

  @AfterEach
  fun tearDown() {
    Browser.closeBrowser()
    TafDynamicContextHolder.clearContext()
    TafStaticContextHolder.clearContext()
  }

  @AfterAll
  fun cleanup() {
    TafStaticContextHolder.clearContext()
    TafDynamicContextHolder.clearContext()
  }
}