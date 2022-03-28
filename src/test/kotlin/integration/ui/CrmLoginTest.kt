package integration.ui

import org.junit.jupiter.api.Test
import services.ui.CrmUiOperationService

class CrmLoginTest : BaseUITest() {

  @Test
  fun `login to crm`() {
    val crmUiOperationService = CrmUiOperationService(applicationConfig)
    crmUiOperationService.logInCrm()
    crmUiOperationService.checkMainPageHeader()
  }
}