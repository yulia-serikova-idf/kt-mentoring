package com.ui

import org.junit.jupiter.api.Test
import pages.MainPage
import pages.blocks.LoginPopUp

class LoginTest : BaseUITest() {

  @Test
  fun new() {
    MainPage().unload()
    LoginPopUp().auth(applicationConfig)
    MainPage().load()
  }
}