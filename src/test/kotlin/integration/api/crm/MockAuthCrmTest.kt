package integration.api.crm

import com.github.tomakehurst.wiremock.WireMockServer
import context.constant.provider.ApplicationConfigProvider
import crm.api.CrmUserAuthorizationController
import integration.BaseContextManagerTest
import mock.controller.MockController
import mock.model.CrmAuthMock
import mock.service.MockService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MockAuthCrmTest : BaseContextManagerTest() {
  private val crmAuthMock: CrmAuthMock = CrmAuthMock()
  private val applicationConfig = ApplicationConfigProvider().getConfigData()
  private val mockController = MockController(MockService())

  @BeforeEach
  fun configWireMockStub() {
    WireMockServer().start()
    mockController.setUp(crmAuthMock)
  }

  @Test
  fun `verify response from real api and fake mock api`() {
    val responseRealApi =
      CrmUserAuthorizationController(applicationConfig.getBaseUrl()).authCrm()
    val responseMock =
      CrmUserAuthorizationController(applicationConfig.getMockUrl()).authCrm()
    Assertions.assertEquals(responseMock, responseRealApi)
  }

  @AfterEach
  fun removeWireMockStub() {
    WireMockServer().stop()
    mockController.remove(crmAuthMock)
  }
}