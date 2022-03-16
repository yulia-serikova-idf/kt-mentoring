package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$x`
import org.slf4j.LoggerFactory

/**
 * пока без собственных ожиданий
 */
class MainPage : BasePage {
  private var logger = LoggerFactory.getLogger(MainPage::class.java)

  private val calcBlock: String = "//div[contains(@class, 'calculator-block')]"

  override fun load() {
    `$x`(calcBlock).shouldBe(Condition.visible)
    logger.info("Successfully entry to main page - see calc block")
  }

  fun unload() {
    `$x`(calcBlock).shouldBe(Condition.not(Condition.visible))
    logger.info("Try entry to main page, calc block is invisible - page not authorized")

  }
}