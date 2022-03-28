package ui.waiter

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By
import org.slf4j.LoggerFactory
import java.time.Duration

object TafUiElementWaiter {
  private var logger = LoggerFactory.getLogger(TafUiElementWaiter::class.java)
  const val defaultWaitElementStateSec: Long = 10

  fun waitElementNotExists(locator: By, timeoutSeconds: Long = defaultWaitElementStateSec) {
    logger.info("Wait for element [$locator] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(locator).shouldBe(Condition.not(Condition.exist), Duration.ofSeconds(timeoutSeconds))
  }

  fun waitElementVisible(locator: By, timeoutSeconds: Long = defaultWaitElementStateSec) {
    logger.info("Wait for element [$locator] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(locator).shouldBe(Condition.visible, Duration.ofSeconds(timeoutSeconds))
  }
}