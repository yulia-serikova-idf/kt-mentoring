package db.dao.user_account

import db.util.DbClient

interface UserAccountDao {
  val dbClient: DbClient
  fun findById(id: Int): Map<String, Any>
  fun findAll(): List<Map<String, Any>>
}