package integration.ui

import org.junit.jupiter.api.Test
import services.api.CrmApiOperationService
import services.ui.CrmUiOperationService

class CrmLoginTest : BaseUITest() {

  @Test
  fun `login to crm`() {
    val crmAuthUserResponse = CrmApiOperationService(applicationConfig).getResponseCrmUserAuthorization()
    CrmUiOperationService(applicationConfig).apply {
      logInCrm()
      checkMainPageHeader(crmAuthUserResponse.userName)
    }
  }
}