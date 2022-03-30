package ui.waiter

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.LoggerFactory
import ui.Browser
import java.time.Duration

object TafUiElementWaiter {
  private var logger = LoggerFactory.getLogger(TafUiElementWaiter::class.java)
  const val defaultWaitElementStateSec: Long = 15

  fun waitElementNotExists(locator: By, timeoutSeconds: Long = defaultWaitElementStateSec) {
    logger.info("Wait for element [$locator] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(locator).shouldBe(Condition.not(Condition.exist), Duration.ofSeconds(timeoutSeconds))
  }

  fun waitElementVisible(locator: By, timeoutSeconds: Long = defaultWaitElementStateSec) {
    logger.info("Wait for element [$locator] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(locator).shouldBe(Condition.visible, Duration.ofSeconds(timeoutSeconds))
  }

  fun waitPageHasDocumentCompleteState(timeoutSeconds: Long = defaultWaitElementStateSec) {
    try {
      WebDriverWait(Browser.getDriver(), timeoutSeconds).until {
        return@until Selenide.executeJavaScript<Any>("return document.readyState") == "complete"
      }
    } catch (e: TimeoutException) {
      logger.error("Failed to wait [Complete] Document ready state within [$timeoutSeconds] seconds")
      throw e
    }
  }
}