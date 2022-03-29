package ui.pages.home

import app.config.model.ApplicationConfig
import ui.pages.DefaultPage
import ui.pages.blocks.CalculatorBlock

class MainPage(applicationConfig: ApplicationConfig) : DefaultPage() {
  override val url = applicationConfig.getBaseUrlWithAuthorisation()
  private val calculatorBlock = CalculatorBlock()

  override fun openPage() {
    super.openPage()
    checkPageIsLoaded()
  }

  fun checkPageIsLoaded() {
    calculatorBlock.checkFrameIsLoaded()
  }
}