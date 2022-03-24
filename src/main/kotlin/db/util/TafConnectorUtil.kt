package db.util

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import db.config.provider.DbConfigProvider

class TafConnectorUtil {
  private var session: Session? = null
  private var dbConfig = DbConfigProvider().getConfigData()

  fun getSession(): Session {
    if (session == null) {
      session = session(dbConfig.getConnectionUrlWithSchema(), dbConfig.user, dbConfig.password)
    }
    return session as Session
  }

  fun closeSessions() {
    session?.connection?.close()
    session = null
  }
}