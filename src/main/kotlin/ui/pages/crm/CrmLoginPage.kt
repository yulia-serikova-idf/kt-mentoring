package ui.pages.crm

import app.config.model.ApplicationConfig
import com.codeborne.selenide.Selenide.`$x`
import ui.Browser
import ui.pages.BasePage
import ui.pages.blocks.CrmLoginBlock
import ui.utils.TafWaiter

class CrmLoginPage(applicationConfig: ApplicationConfig) : BasePage {
  override val url = applicationConfig.setRoute("/new-admin/#/login")
  private val loginBlock = CrmLoginBlock()
  private val loginInput = "//input[@name='username']"
  private val passwordInput = "//input[@name='password']"
  private val captchaInput = "//input[@ng-model='loginData.captcha']"
  private val submitButton = "//button[@type='submit']"

  override fun openPage() {
    Browser.openWithUrl(url)
    checkPageIsLoaded()
  }

  override fun checkPageIsLoaded() {
    loginBlock.checkFrameIsLoaded()
  }

  fun inputLogin(login: String) {
    `$x`(loginInput).value = login
  }

  fun inputPassword(password: String) {
    `$x`(passwordInput).value = password
  }

  fun inputCaptcha(captcha: String) {
    `$x`(captchaInput).value = captcha
  }

  fun clickButton() {
    val button = `$x`(submitButton)
    button.click()
    TafWaiter().waitElementNotExists(button, 15)
  }
}