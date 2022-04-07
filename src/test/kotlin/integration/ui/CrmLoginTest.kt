package integration.ui

import context.contextApplicationConfig
import context.jSessionCookie
import crm.api.model.CrmUserResponse
import org.junit.jupiter.api.Test
import services.api.CrmApiOperationService
import services.ui.CrmUiOperationService
import ui.pages.crm.CrmMainPage

class CrmLoginTest : BaseUITest() {

  @Test
  fun `verify userName on crm main page header by api response data`() {
    val crmAuthUserResponse = CrmApiOperationService(contextApplicationConfig().getBaseUrl())
      .getResponseCrmUserAuthorization().convertBodyToObj(CrmUserResponse::class.java)
    CrmUiOperationService(contextApplicationConfig()).apply {
      logInCrm()
      checkMainPageHeader(crmAuthUserResponse.userName)
    }
  }

  @Test
  fun `verify crm login by JSESSION from api response`() {
    CrmApiOperationService(contextApplicationConfig().getBaseUrl()).getResponseCrmUserAuthorization()
    jSessionCookie()?.let { CrmUiOperationService(contextApplicationConfig()).openLoginAndSetCookie(it) }
    CrmMainPage(contextApplicationConfig()).openPage()
  }
}