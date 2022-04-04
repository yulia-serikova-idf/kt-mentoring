package mock.model

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import converter.FileToString

class TafMappingMockBuilder {

  fun getStubMapping(mockConfig: TafMock): MappingBuilder? {
    return with(mockConfig) {
      WireMock.any(urlEqualTo(mockEndpoint))
        .atPriority(priority)
        .withName(mockName)
        ?.willReturn(getStubResponseConfig(mockConfig))
    }
  }

  private fun getStubResponseConfig(mockConfig: TafMock): ResponseDefinitionBuilder? {
    with(mockConfig) {
      val responseDefinitionBuilder = WireMock.aResponse()
      responseDefinitionBuilder
        .withStatus(status!!)
        .withBody(FileToString.getMockDataFromFileToString(responseFilePath!!))
      header.forEach {
        responseDefinitionBuilder.withHeader(it.key, it.value)
      }
      return responseDefinitionBuilder
    }
  }
}