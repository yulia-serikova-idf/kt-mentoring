package ui

import com.codeborne.selenide.Selenide.closeWebDriver
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.refresh
import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver
import org.slf4j.LoggerFactory
import ui.waiter.TafUiElementWaiter

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

  fun getDriver(): WebDriver {
    return WebDriverRunner.getWebDriver()
  }

  fun addCookie(name: String, value: String) {
    getDriver().manage().addCookie(Cookie(name, value))
    logger.info("Add cookie [$name]=[$value]")
    refreshPage()
  }

  fun refreshPage() {
    refresh()
    TafUiElementWaiter.waitPageHasDocumentCompleteState()
    logger.info("Page was refreshed")
  }
}