package db.services

import db.BaseDbTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserAccountServiceTest : BaseDbTest() {
  val userAccountService = UserAccountService()
  val expectedUserName = "Sergey Shikunets"
  val expectedUserEmail = "test2@moneyman.ru"
  val testExpectedCountBlockedUsers = 102

  @Test
  fun `verify UserAccount - check name and email by id`() {
    val actualMap: Map<String, Any> = userAccountService.getUserNameAndEmailById(1)
    Assertions.assertEquals(expectedUserName, actualMap["name"])
    Assertions.assertEquals(expectedUserEmail, actualMap["email"])
  }

  @Test
  fun `verify UserAccount - check count of blocked users `() {
    val testActualCountBlockedUsers = userAccountService.getAllBlockedUsers().count()
    Assertions.assertEquals(testExpectedCountBlockedUsers, testActualCountBlockedUsers)
  }
}