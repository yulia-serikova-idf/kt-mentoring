package integration.api.crm

import app.config.provider.ApplicationConfigProvider
import crm.api.CrmUserAuthorizationController
import mock.controller.MockController
import mock.model.CrmAuthMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MockAuthCrmTest {
  private val crmAuthMock: CrmAuthMock = CrmAuthMock()
  private val applicationConfig = ApplicationConfigProvider().getConfigData()
  private val mockController = MockController(applicationConfig)

  @BeforeEach
  fun configWireMockStub() {
    mockController.setUp(crmAuthMock)
  }

  @Test
  fun `verify response from real api and fake mock api`() {
    val responseRealApi = CrmUserAuthorizationController(applicationConfig).authCrm()
    val responseMock = CrmUserAuthorizationController(applicationConfig.getMockAppConfig()).authCrm()
    Assertions.assertEquals(responseMock, responseRealApi)
  }

  @AfterEach
  fun removeWireMockStub() {
    //  wireMockServer?.stop()
    mockController.remove(crmAuthMock)
  }
}