package integration.ui

import crm.api.CrmUserAuthorizationController
import org.junit.jupiter.api.Test
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmLoginTest : BaseUITest() {

  @Test
  fun `login to crm`() {
    val responseCrmUserData = CrmUserAuthorizationController().authCrm()
    val crmUser = applicationConfig.crmUser
    val crmLoginPage = CrmLoginPage(applicationConfig)
    crmLoginPage.apply {
      openPage()
      inputLogin(crmUser.login)
      inputPassword(crmUser.password)
      inputCaptcha(crmUser.captcha)
      clickButton()
    }
    CrmMainPage(applicationConfig).apply {
      openPage()
      checkHeaderCrmUserName(responseCrmUserData.userName)
    }
  }
}