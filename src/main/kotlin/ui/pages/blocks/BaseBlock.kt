package ui.pages.blocks

interface BaseBlock {
  val mainFrameLocator: String
  fun checkFrameIsLoaded()
}