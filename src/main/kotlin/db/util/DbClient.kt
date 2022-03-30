package db.util

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getSession(): Session
  fun closeSessions()
  fun findAny(queryString: String, vararg param: Any): Map<String, Any>
  fun findAll(queryString: String, vararg param: Any): List<HashMap<String, Any>>
}