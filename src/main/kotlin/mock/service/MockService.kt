package mock.service

import app.config.model.ApplicationConfig
import com.github.tomakehurst.wiremock.client.WireMock
import mock.config.model.MockConfig
import mock.model.TafMappingMockBuilder
import mock.model.TafMock

class MockService(applicationConfig: ApplicationConfig) {
  private val mockConfig: MockConfig = applicationConfig.mockConfig
  private val wireMockConfigBuilder: TafMappingMockBuilder = TafMappingMockBuilder()
  private val mock: WireMock = WireMock.create().scheme("http")
    .host(mockConfig.host).port(mockConfig.port).build()

  fun registerStubs(mockConfig: TafMock) {
    mockConfig.mappingBuilder = wireMockConfigBuilder.getStubMapping(mockConfig)
    mock.register(mockConfig.mappingBuilder).apply { mockConfig.id = this.id }
    verifyStub(mockConfig)
  }

  private fun verifyStub(mockConfig: TafMock) {
    mock.getStubMapping(mockConfig.id) ?: throw IllegalArgumentException("Stub doesn't raise")
  }

  fun removeStubs(mockConfig: TafMock) {
    mock.removeStubMapping(mockConfig.mappingBuilder)
  }
}