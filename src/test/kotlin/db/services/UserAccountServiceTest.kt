package db.services

import db.BaseDbTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserAccountServiceTest : BaseDbTest() {
  val userAccountService = UserAccountService()
  val testExpectedDataNameAndEmail = "test2@moneyman.ru | Sergey Shikunets"
  val testExpectedCountBlockedUsers = 102

  @Test
  fun `verify UserAccount - check name and email by id`() {
    val testActualDataNameAndEmail = userAccountService.getUserNameAndEmailById(1)
    Assertions.assertEquals(testExpectedDataNameAndEmail, testActualDataNameAndEmail)
  }

  @Test
  fun `verify UserAccount - check count of blocked users `() {
    val testActualCountBlockedUsers = userAccountService.getAllBlockedUsers().count()
    Assertions.assertEquals(testExpectedCountBlockedUsers, testActualCountBlockedUsers)
  }
}