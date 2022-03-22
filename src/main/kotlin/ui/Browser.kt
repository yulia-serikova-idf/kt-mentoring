package ui

import com.codeborne.selenide.Selenide.closeWebDriver
import com.codeborne.selenide.Selenide.open
import org.slf4j.LoggerFactory

object Browser {
  private var logger = LoggerFactory.getLogger(Browser::class.java)

  fun closeBrowser() {
    closeWebDriver()
    logger.info("Browser is closed")
  }

  fun openWithUrl(url: String) {
    logger.info("Try to open with url $url")
    open(url)
  }
}