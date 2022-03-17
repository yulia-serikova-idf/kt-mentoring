package ui.pages.home

import config.model.ApplicationConfig
import org.slf4j.LoggerFactory
import ui.pages.BasePage
import ui.pages.blocks.CalculatorBlock

/**
 * пока без собственных ожиданий
 */
class MainPage(applicationConfig: ApplicationConfig) : BasePage {
  private var logger = LoggerFactory.getLogger(MainPage::class.java)

  override val url = applicationConfig.getBaseUrlWithAuthorisation()

  private val calculatorBlock = CalculatorBlock()

  override fun checkPageIsLoaded() {
    calculatorBlock.checkFrameIsLoaded()
    logger.info("Successfully entry to main page - see calc block")
  }


}