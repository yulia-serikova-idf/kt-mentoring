package mock.controller

import mock.model.TafMock
import mock.service.MockService

class MockController(private val mockService: MockService) {
  fun setUp(mockConfig: TafMock) = mockService.registerStubs(mockConfig)
  fun remove(mockConfig: TafMock) = mockService.removeStubs(mockConfig)
}