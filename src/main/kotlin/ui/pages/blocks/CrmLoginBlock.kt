package ui.pages.blocks

import com.codeborne.selenide.Selenide.`$x`
import org.slf4j.LoggerFactory
import ui.utils.TafWaiter

class CrmLoginBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CrmLoginBlock::class.java)
  override val blockLocator: String = "//form[@action = '/#/login']"

  override fun checkFrameIsLoaded() {
    TafWaiter().waitElementVisible(`$x`(blockLocator), 15)
    logger.info("Crm login block is visible")
  }
}