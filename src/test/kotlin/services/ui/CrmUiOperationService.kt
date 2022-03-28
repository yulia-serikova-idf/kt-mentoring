package services.ui

import crm.api.model.CrmUserResponse
import crm.config.model.CrmUser
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmUiOperationService {

  fun logInCrm(crmLoginPage: CrmLoginPage, crmUser: CrmUser) {
    crmLoginPage.openPage()
    crmLoginPage.loginBlock.apply {
      inputLogin(crmUser.login)
      inputPassword(crmUser.password)
      inputCaptcha(crmUser.captcha)
      clickButton()
    }
  }

  fun checkMainPageHeader(crmMainPage: CrmMainPage, crmUserResponse: CrmUserResponse) {
    crmMainPage.openPage()
    crmMainPage.headerBlock.checkHeaderCrmUserName(crmUserResponse.userName)
  }
}