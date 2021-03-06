package ui.pages.crm

import app.config.model.ApplicationConfig
import ui.pages.DefaultPage
import ui.pages.blocks.CrmLoginBlock

class CrmLoginPage(applicationConfig: ApplicationConfig) : DefaultPage() {
  override val url = applicationConfig.setRoute("/new-admin/#/login")
  val loginBlock = CrmLoginBlock()

  override fun openPage() {
    super.openPage()
    loginBlock.checkFrameIsLoaded()
  }
}