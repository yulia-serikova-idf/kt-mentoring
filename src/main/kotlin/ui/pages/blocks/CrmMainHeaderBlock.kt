package ui.pages.blocks

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.slf4j.LoggerFactory
import ui.waiter.TafUiElementWaiter
import ui.waiter.TafUiElementWaiter.defaultWaitElementStateSec

class CrmMainHeaderBlock : BaseBlock {
  private var logger = LoggerFactory.getLogger(CrmMainHeaderBlock::class.java)
  override val blockLocator: By =
    By.cssSelector("header[id='header'] div[class='header_accountInfo'] a[href='#changePassword']")

  override fun checkFrameIsLoaded() {
    logger.info("Verify crm main page header block is visible")
    TafUiElementWaiter.waitElementVisible(blockLocator, defaultWaitElementStateSec)
  }

  fun checkHeaderCrmUserName(fullName: String) {
    `$`(blockLocator).shouldHave(Condition.text(fullName))
  }
}