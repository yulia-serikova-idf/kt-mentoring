package integration.ui

import org.junit.jupiter.api.Test
import ui.Browser
import ui.pages.home.MainPage

class LoginTest : BaseUITest() {

  @Test
  fun `check success login to CRM`() {
    val mainPage = MainPage(applicationConfig)
    Browser.openWithUrl(mainPage.url)
    mainPage.checkPageIsLoaded()
  }
}