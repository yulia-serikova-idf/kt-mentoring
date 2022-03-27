package db.services

import db.dao.user_account.UserAccountImpl

class UserAccountService {
  private val userAccountImpl = UserAccountImpl()

  fun getUserNameAndEmailById(id: Int): Map<String, Any> {
    return userAccountImpl.findById(id)
  }

  fun getAllBlockedUsers(): List<Map<String, Any>> {
    val allUsersList = userAccountImpl.findAll()
    val resultList: ArrayList<HashMap<String, Any>> = ArrayList()
    allUsersList.forEach { user ->
      if (user.get("blocked") as Boolean) {
        resultList.add(user)
      }
    }
    return resultList
  }
}