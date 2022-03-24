package db.dao.user_account

import db.dao.TafStatementManager

class UserAccountImpl : UserAccountDao {
  private val statementManager = TafStatementManager()

  override fun findById(id: Int): Map<String, Any> {
    return statementManager.findAny("select * from user_account where id = ?", id)
  }

  override fun findAll(): List<HashMap<String, Any>> {
    return statementManager.findAll("select * from user_account")
  }
}