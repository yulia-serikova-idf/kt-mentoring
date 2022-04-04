package services.ui

import app.config.model.ApplicationConfig
import ui.Browser
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmUiOperationService(private val applicationConfig: ApplicationConfig) {
  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage(applicationConfig) }
  private val crmMainPage: CrmMainPage by lazy { CrmMainPage(applicationConfig) }

  fun logInCrm() {
    crmLoginPage.openPage()
    crmLoginPage.loginBlock.apply {
      inputLogin(applicationConfig.crmUser.login)
      inputPassword(applicationConfig.crmUser.password)
      inputCaptcha(applicationConfig.crmUser.captcha)
      clickButton()
    }
  }

  fun checkMainPageHeader(userName: String) {
    crmMainPage.openPage()
    crmMainPage.headerBlock.checkHeaderCrmUserName(userName)
  }

  fun openLoginAndSetCookie(cookie: Map<String, String>) {
    crmLoginPage.openPage()
    cookie[cookie.keys.first().toString()]?.let { Browser.addCookie(cookie.keys.first(), it) }
  }
}