package pages.blocks

import com.codeborne.selenide.WebDriverRunner
import config.model.ApplicationConfig
import org.slf4j.LoggerFactory

class LoginPopUp {
  private var logger = LoggerFactory.getLogger(LoginPopUp::class.java)

  fun auth(applicationConfig: ApplicationConfig) {
    WebDriverRunner.getWebDriver().navigate().to(applicationConfig.getAuthLink())
    logger.info("Authorize to ${applicationConfig.getLink()}")
  }
}