package ui

import com.codeborne.selenide.Selenide
import org.slf4j.LoggerFactory

object Browser {
  private var logger = LoggerFactory.getLogger(Browser::class.java)

  fun closeBrowser() {
    Selenide.closeWebDriver()
    logger.info("Browser is closed")
  }

  fun openWithUrl(url: String) {
    Selenide.open(url)
    logger.info("Open with url $url")
  }
}