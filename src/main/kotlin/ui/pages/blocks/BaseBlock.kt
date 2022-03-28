package ui.pages.blocks

import org.openqa.selenium.By

interface BaseBlock {
  val blockLocator: By
  fun checkFrameIsLoaded()
}