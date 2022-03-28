package services.ui

import app.config.model.ApplicationConfig
import crm.api.model.CrmUserResponse
import services.api.CrmApiOperationService
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmUiOperationService(private val applicationConfig: ApplicationConfig) {
  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage(applicationConfig) }
  private val crmMainPage: CrmMainPage by lazy { CrmMainPage(applicationConfig) }
  private val crmAuthUserResponse: CrmUserResponse by lazy {
    CrmApiOperationService(applicationConfig)
      .getResponseCrmUserAuthorization()
  }

  fun logInCrm() {
    crmLoginPage.openPage()
    crmLoginPage.loginBlock.apply {
      inputLogin(applicationConfig.crmUser.login)
      inputPassword(applicationConfig.crmUser.password)
      inputCaptcha(applicationConfig.crmUser.captcha)
      clickButton()
    }
  }

  fun checkMainPageHeader() {
    crmMainPage.openPage()
    crmMainPage.headerBlock.checkHeaderCrmUserName(crmAuthUserResponse.userName)
  }
}