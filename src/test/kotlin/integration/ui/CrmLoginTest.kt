package integration.ui

import controllers.CrmUiLoginTestsController
import org.junit.jupiter.api.Test

class CrmLoginTest : BaseUITest() {

  @Test
  fun `login to crm`() {
    CrmUiLoginTestsController(applicationConfig).logInToCrm()
  }
}