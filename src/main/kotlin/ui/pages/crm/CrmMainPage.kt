package ui.pages.crm

import context.constant.application.ApplicationConfig
import ui.pages.DefaultPage
import ui.pages.blocks.CrmMainHeaderBlock

class CrmMainPage(applicationConfig: ApplicationConfig) : DefaultPage() {
  override val url = applicationConfig.setRoute("/new-admin/#")
  val headerBlock = CrmMainHeaderBlock()

  override fun openPage() {
    super.openPage()
    headerBlock.checkFrameIsLoaded()
  }
}