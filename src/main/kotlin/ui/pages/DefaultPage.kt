package ui.pages

import ui.Browser

abstract class DefaultPage : BasePage {
  override val url: String = "about:blank"

  override fun openPage() {
    Browser.openWithUrl(url)
  }
}