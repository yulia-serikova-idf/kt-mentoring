package elements

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.slf4j.LoggerFactory

object Button {
  private var logger = LoggerFactory.getLogger(Button::class.java)

  fun click(locator: By) {
    `$`(locator).click()
    logger.info("Click on button $locator")
  }
}