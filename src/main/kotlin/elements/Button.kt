package elements

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

object Button {
  fun click(by: By) {
    `$`(by).click()
  }
}