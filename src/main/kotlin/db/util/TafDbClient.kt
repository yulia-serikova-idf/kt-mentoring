package db.util

import app.config.provider.ApplicationConfigProvider
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery

class TafDbClient : DbClient {
  private var session: Session? = null
  private var dbConfig = ApplicationConfigProvider().getConfigData().dbConfig

  override fun getSession(): Session {
    if (session == null) {
      session = session(dbConfig.getConnectionUrlWithSchema(), dbConfig.user, dbConfig.password)
    }
    return session as Session
  }

  override fun closeSessions() {
    session?.connection?.close()
    session = null
  }

  override fun findAny(queryString: String, vararg param: Any): Map<String, Any> {
    val query = sqlQuery(queryString).params(params = param)
    return getSession().first(query, TafExtractorDataSet.extractRow)!!
  }

  override fun findAll(queryString: String, vararg param: Any): List<HashMap<String, Any>> {
    val query = sqlQuery(queryString).params(params = param)
    return getSession().list(query, TafExtractorDataSet.extractRow)
  }
}