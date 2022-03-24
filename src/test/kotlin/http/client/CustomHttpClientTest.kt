package http.client

import app.config.model.ApplicationConfig
import app.config.provider.ApplicationConfigProvider
import config.provider.TafProperties.CONFIG_MYEXCEPT_MESSAGE
import config.utils.AppConfigReader
import http.model.response.TafResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * TODO MOCK
 */
class CustomHttpClientTest {
  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getConfigData()
  val wrongRoute: String = "/client-area/registration1"

  @Test
  fun `verify registration get request - response non null`() {
    val response: TafResponse = CustomHttpClient().get(applicationConfig.getRegistrationRoutePath())
    Assertions.assertNotNull(response)
  }

  @Test
  fun `verify registration get request -  AuthUser param in response cookie non null`() {
    val expectedCookieName = "AuthUser"
    val response: TafResponse = CustomHttpClient().get(applicationConfig.getRegistrationRoutePath())
    Assertions.assertNotNull(response.getCookieByName(expectedCookieName))
  }

  @Test
  fun `verify registration get request - exception message when route is wrong`() {
    val exception: Exception = assertThrows(Exception::class.java)
    { CustomHttpClient().get(applicationConfig.setRoute(wrongRoute)) }
    val expectedMessage = AppConfigReader.getConfigParam(CONFIG_MYEXCEPT_MESSAGE)
    val actualMessage = exception.message
    Assertions.assertTrue(actualMessage!!.contains(expectedMessage))
  }
}