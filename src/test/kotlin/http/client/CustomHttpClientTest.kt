package http.client

import config.model.ApplicationConfig
import config.provider.ApplicationConfigProvider
import config.provider.TafProperties.CONFIG_MYEXCEPT_MESSAGE
import config.provider.TafProperties.CONFIG_REGISTRATION_ROUTE
import config.provider.TafProperties.CONFIG_REGISTRATION_ROUTE_WRONG
import config.utils.AppConfigReader
import http.model.response.TafResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CustomHttpClientTest {
  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getConfigData()
  val route: String = AppConfigReader.getConfigParam(CONFIG_REGISTRATION_ROUTE)
  val wrongRoute: String = AppConfigReader.getConfigParam(CONFIG_REGISTRATION_ROUTE_WRONG)

  @Test
  fun `verify response non null`() {
    val response: TafResponse = CustomHttpClient().get(applicationConfig.setRoute(route))
    Assertions.assertNotNull(response)
  }

  @Test
  fun `verify AuthUser param in cookie`() {
    val response: TafResponse = CustomHttpClient().get(applicationConfig.setRoute(route))
    Assertions.assertNotNull(response.getCookieParam("AuthUser"))
  }

  @Test
  fun `verify exception message when route is wrong`() {
    val exception: Exception = assertThrows(Exception::class.java)
    { CustomHttpClient().get(applicationConfig.setRoute(wrongRoute)) }
    val expectedMessage = AppConfigReader.getConfigParam(CONFIG_MYEXCEPT_MESSAGE)
    val actualMessage = exception.message
    Assertions.assertTrue(actualMessage!!.contains(expectedMessage));
  }
}