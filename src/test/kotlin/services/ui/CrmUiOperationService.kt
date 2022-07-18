package services.ui

import context.constant.application.ApplicationConfig
import context.contextApplicationConfig
import ui.Browser
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmUiOperationService(private val applicationConfig: ApplicationConfig = contextApplicationConfig()) {
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

  fun openLoginAndSetCookie(cookie: Pair<String, String>) {
    crmLoginPage.openPage()
    cookie?.let { Browser.addCookie(it.first, it.second) }
  }
}