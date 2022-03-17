package ui.pages

interface BasePage {
  val url: String
  fun checkPageIsLoaded()
}