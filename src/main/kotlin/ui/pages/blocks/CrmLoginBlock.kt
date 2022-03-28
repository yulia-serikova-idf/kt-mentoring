package ui.pages.blocks

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.slf4j.LoggerFactory
import ui.waiter.TafUiElementWaiter
import ui.waiter.TafUiElementWaiter.defaultWaitElementStateSec

class CrmLoginBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CrmLoginBlock::class.java)
  override val blockLocator: By = By.xpath("//form[@action = '/#/login']")
  private val loginInput = By.xpath("//input[@name='username']")
  private val passwordInput = By.xpath("//input[@name='password']")
  private val captchaInput = By.xpath("//input[@ng-model='loginData.captcha']")
  private val submitButton = By.xpath("//button[@type='submit']")

  override fun checkFrameIsLoaded() {
    logger.info("Verify crm login block is visible")
    TafUiElementWaiter.waitElementVisible(blockLocator, defaultWaitElementStateSec)
  }

  fun inputLogin(login: String) {
    `$`(loginInput).value = login
  }

  fun inputPassword(password: String) {
    `$`(passwordInput).value = password
  }

  fun inputCaptcha(captcha: String) {
    `$`(captchaInput).value = captcha
  }

  fun clickButton() {
    `$`(submitButton).click()
    TafUiElementWaiter.waitElementNotExists(submitButton, defaultWaitElementStateSec)
  }
}