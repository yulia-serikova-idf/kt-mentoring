package db.services

import db.dao.user_account.UserAccountImpl

class UserAccountService {
  private val userAccountImpl = UserAccountImpl()

  fun getUserNameAndEmailById(id: Int): String {
    val userAccountRow = userAccountImpl.findById(id)
    return userAccountRow.get("email").toString() + " | " + userAccountRow.get("name").toString()
  }

  fun getAllBlockedUsers(): List<Map<String, Any>> {
    val allUsersList = userAccountImpl.findAll()
    var resultList: ArrayList<HashMap<String, Any>> = ArrayList()
    allUsersList.forEach { user ->
      run {
        if (user.get("blocked") as Boolean) {
          resultList.add(user)
        }
      }
    }
    return resultList
  }
}