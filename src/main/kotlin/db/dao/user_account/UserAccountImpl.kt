package db.dao.user_account

import db.util.TafDbClient

class UserAccountImpl : UserAccountDao {
  override val dbClient = TafDbClient()

  override fun findById(id: Int): Map<String, Any> {
    return dbClient.findAny("select * from user_account where id = ?", id)
  }

  override fun findAll(): List<HashMap<String, Any>> {
    return dbClient.findAll("select * from user_account")
  }
}