package mock.controller

import app.config.model.ApplicationConfig
import mock.model.TafMock
import mock.service.MockService

class MockController(applicationConfig: ApplicationConfig) {
  private val mockService: MockService = MockService(applicationConfig)
  fun setUp(mockConfig: TafMock) = mockService.registerStubs(mockConfig)
  fun remove(mockConfig: TafMock) = mockService.removeStubs(mockConfig)
}