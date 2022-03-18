package elements

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.slf4j.LoggerFactory

object Button {
  private var logger = LoggerFactory.getLogger(Button::class.java)

  fun click(locator: By) {
    logger.info("Try click on button $locator")
    `$`(locator).click()
  }
}