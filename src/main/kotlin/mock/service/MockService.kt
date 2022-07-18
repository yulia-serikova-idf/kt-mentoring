package mock.service

import com.github.tomakehurst.wiremock.client.WireMock
import context.contextApplicationConfig
import mock.model.TafMappingMockBuilder
import mock.model.TafMock

class MockService() {
  private val wireMockConfigBuilder: TafMappingMockBuilder = TafMappingMockBuilder()
  private val mock: WireMock = WireMock.create().scheme("http")
    .host(contextApplicationConfig().mockConfig.host).port(contextApplicationConfig().mockConfig.port).build()

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