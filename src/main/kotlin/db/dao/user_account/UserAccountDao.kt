package db.dao.user_account

interface UserAccountDao {
  fun findById(id: Int): Map<String, Any>
  fun findAll(): List<Map<String, Any>>
}