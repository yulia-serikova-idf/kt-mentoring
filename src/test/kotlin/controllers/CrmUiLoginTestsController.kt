package controllers

import app.config.model.ApplicationConfig
import services.api.CrmApiOperationService
import services.ui.CrmUiOperationService
import ui.pages.crm.CrmLoginPage
import ui.pages.crm.CrmMainPage

class CrmUiLoginTestsController(private val applicationConfig: ApplicationConfig) {
  private val crmUiOperationService = CrmUiOperationService()
  private val crmAuthUserResponse = CrmApiOperationService(applicationConfig).getResponseCrmUserAuthorization()

  fun logInToCrm() {
    crmUiOperationService.logInCrm(CrmLoginPage(applicationConfig), applicationConfig.crmUser)
    crmUiOperationService.checkMainPageHeader(CrmMainPage(applicationConfig), crmAuthUserResponse)
  }
}