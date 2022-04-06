package integration.ui

import context.contextApplicationConfig
import org.junit.jupiter.api.Test
import ui.pages.home.MainPage

class LoginTest : BaseUITest() {

  @Test
  fun `check success login to CRM`() {
    val mainPage = MainPage(contextApplicationConfig())
    mainPage.openPage()
  }
}