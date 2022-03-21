package ui.pages.blocks

interface BaseBlock {
  val blockLocator: String
  fun checkFrameIsLoaded()
}