package ui.utils

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.slf4j.LoggerFactory
import java.time.Duration

class TafWaiter {
  private var logger = LoggerFactory.getLogger(TafWaiter::class.java)

  fun waitElementNotExists(element: SelenideElement, timeoutSeconds: Long) {
    logger.info("Wait for element [$element] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(element).shouldBe(Condition.not(Condition.exist), Duration.ofSeconds(timeoutSeconds))
  }

  fun waitElementVisible(element: SelenideElement, timeoutSeconds: Long) {
    logger.info("Wait for element [$element] not exists. Max wait period [$timeoutSeconds] seconds")
    Selenide.`$`(element).shouldBe(Condition.visible, Duration.ofSeconds(timeoutSeconds))
  }
}