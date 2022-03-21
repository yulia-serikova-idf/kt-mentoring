package ui.pages.blocks

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$x`
import org.slf4j.LoggerFactory

class CalculatorBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CalculatorBlock::class.java)
  override val blockLocator: String = "//div[contains(@class, 'calculator-block')]"

  override fun checkFrameIsLoaded() {
    `$x`(blockLocator).shouldBe(Condition.visible)
    logger.info("Calculator block is visible")
  }
}