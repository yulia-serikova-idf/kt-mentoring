package ui.pages.crm

import app.config.model.ApplicationConfig
import ui.Browser
import ui.pages.BasePage
import ui.pages.blocks.CrmMainHeaderBlock

class CrmMainPage(applicationConfig: ApplicationConfig) : BasePage {
  override val url = applicationConfig.setRoute("/new-admin/#")
  private val headerBlock = CrmMainHeaderBlock()

  override fun openPage() {
    Browser.openWithUrl(url)
    checkPageIsLoaded()
  }

  override fun checkPageIsLoaded() {
    headerBlock.checkFrameIsLoaded()
  }

  fun checkHeaderCrmUserName(fullName: String) {
    headerBlock.checkUserName(fullName)
  }
}