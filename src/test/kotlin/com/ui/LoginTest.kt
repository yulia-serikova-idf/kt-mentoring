package com.ui

import org.junit.jupiter.api.Test
import pages.MainPage
import pages.blocks.LoginPopUp

class LoginTest : BaseUITest() {

  private val mainPage = MainPage()

  @Test
  fun new() {
    mainPage.unload()
    LoginPopUp().auth(applicationConfig)
    mainPage.load()
  }
}