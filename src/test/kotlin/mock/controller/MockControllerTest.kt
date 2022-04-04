package mock.controller

import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import mock.model.CrmAuthMock
import mock.service.MockService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockControllerTest {

  private lateinit var mockController: MockController

  @MockK
  private lateinit var mockService: MockService
  val crmAuthMock = mockk<CrmAuthMock>(relaxed = true)

  @BeforeEach
  fun setup() {
    mockController = MockController(mockService)
  }

  @Test
  fun `verify calls mockController setUp`() {
    every { mockService.registerStubs(any()) } just Runs
    every { mockService.verifyStub(any()) } just Runs
    mockController.setUp(mockConfig = crmAuthMock)
    verify(exactly = 1) { mockService.registerStubs(any()) }
  }

  @Test
  fun `verify calls mockController remove`() {
    every { mockService.removeStubs(any()) } just Runs
    mockController.remove(mockConfig = crmAuthMock)
    verify(exactly = 1) { mockService.removeStubs(any()) }
  }

  @AfterEach
  fun tearDown() {
    clearAllMocks()
  }
}