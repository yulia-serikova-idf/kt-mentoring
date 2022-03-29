package integration.ui

import org.junit.jupiter.api.Test
import services.api.CrmApiOperationService
import services.ui.CrmUiOperationService

class CrmLoginTest : BaseUITest() {

  @Test
  fun `verify userName on crm main page header by api response data`() {
    val crmAuthUserResponse = CrmApiOperationService(applicationConfig).getResponseCrmUserAuthorization()
    CrmUiOperationService(applicationConfig).apply {
      logInCrm()
      checkMainPageHeader(crmAuthUserResponse.userName)
    }
  }
}