package mock.service

import app.config.model.ApplicationConfig
import com.github.tomakehurst.wiremock.client.WireMock
import mock.model.TafMappingMockBuilder
import mock.model.TafMock

class MockService(private val applicationConfig: ApplicationConfig) {
  private val wireMockConfigBuilder: TafMappingMockBuilder = TafMappingMockBuilder()
  private val mock: WireMock = WireMock.create().scheme("http")
    .host(applicationConfig.mockConfig.host).port(applicationConfig.mockConfig.port).build()

  fun registerStubs(mockConfig: TafMock) {
    mock.register(wireMockConfigBuilder.getStubMapping(mockConfig)).apply { mockConfig.id = this.id }
    verifyStub(mockConfig)
  }

  fun verifyStub(mockConfig: TafMock) {
    mock.getStubMapping(mockConfig.id) ?: throw IllegalArgumentException("Stub doesn't raise")
  }

  fun removeStubs(mockConfig: TafMock) {
    mockConfig.id?.also { id ->
      mock.removeStubMapping(mock.getStubMapping(id).item)
    }
  }
}