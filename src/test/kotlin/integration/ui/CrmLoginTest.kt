package integration.ui

import context.jSessionCookie
import org.junit.jupiter.api.Test
import services.api.CrmApiOperationService
import services.ui.CrmUiOperationService
import ui.pages.crm.CrmMainPage

class CrmLoginTest : BaseUITest() {

  @Test
  fun `verify userName on crm main page header by api response data`() {
    val crmAuthUserResponse = CrmApiOperationService(applicationConfig.getBaseUrl(), applicationConfig.crmUser)
      .getResponseCrmUserAuthorization()
    CrmUiOperationService(applicationConfig).apply {
      logInCrm()
      checkMainPageHeader(crmAuthUserResponse.userName)
    }
  }

  @Test
  fun `verify crm login by JSESSION from api response`() {
    jSessionCookie?.let { CrmUiOperationService(applicationConfig).openLoginAndSetCookie(it) }
    CrmMainPage(applicationConfig).openPage()
  }
}