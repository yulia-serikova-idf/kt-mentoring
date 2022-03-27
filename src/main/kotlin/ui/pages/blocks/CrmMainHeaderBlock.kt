package ui.pages.blocks

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.slf4j.LoggerFactory
import ui.utils.TafWaiter

class CrmMainHeaderBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CrmMainHeaderBlock::class.java)
  override val blockLocator = "header[id='header'] "
  private val headerUserInfoBlock = blockLocator + "div[class='header_accountInfo'] a[href='#changePassword']"

  override fun checkFrameIsLoaded() {
    TafWaiter().waitElementVisible(`$`(headerUserInfoBlock), 15)
    logger.info("Crm main page header block is visible")
  }

  fun checkUserName(fullName: String) {
    `$`(headerUserInfoBlock).shouldHave(Condition.text(fullName))
  }
}