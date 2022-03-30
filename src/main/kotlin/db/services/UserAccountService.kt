package db.services

import db.dao.user_account.UserAccountRu
import db.util.TafDbClient

class UserAccountService() {
  private val userAccountRu = UserAccountRu(TafDbClient())

  fun getUserNameAndEmailByIdRu(id: Int): Map<String, Any> {
    return userAccountRu.findById(id)
  }

  fun getAllBlockedUsersRu(): List<Map<String, Any>> {
    val allUsersList = userAccountRu.findAll()
    val resultList: ArrayList<HashMap<String, Any>> = ArrayList()
    allUsersList.forEach { user ->
      if (user.get("blocked") as Boolean) {
        resultList.add(user)
      }
    }
    return resultList
  }
}