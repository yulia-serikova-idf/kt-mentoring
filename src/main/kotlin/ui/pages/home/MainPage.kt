package ui.pages.home

import app.config.model.ApplicationConfig
import ui.Browser
import ui.pages.BasePage
import ui.pages.blocks.CalculatorBlock

/**
 * пока без собственных ожиданий
 */
class MainPage(applicationConfig: ApplicationConfig) : BasePage {
  override val url = applicationConfig.getBaseUrlWithAuthorisation()
  private val calculatorBlock = CalculatorBlock()

  override fun openPage() {
    Browser.openWithUrl(url)
    checkPageIsLoaded()
  }

  override fun checkPageIsLoaded() {
    calculatorBlock.checkFrameIsLoaded()
  }
}