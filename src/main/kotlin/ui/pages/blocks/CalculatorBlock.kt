package ui.pages.blocks

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.slf4j.LoggerFactory

class CalculatorBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CalculatorBlock::class.java)
  override val blockLocator: By = By.xpath("//div[contains(@class, 'calculator-block')]")

  override fun checkFrameIsLoaded() {
    `$`(blockLocator).shouldBe(Condition.visible)
    logger.info("Calculator block is visible")
  }
}