package db_entities.util

import app.config.provider.ApplicationConfigProvider
import org.hibernate.cfg.AvailableSettings.JPA_JDBC_PASSWORD
import org.hibernate.cfg.AvailableSettings.JPA_JDBC_URL
import org.hibernate.cfg.AvailableSettings.JPA_JDBC_USER
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object EntityDbClient {
  var entityManagerFactory: EntityManagerFactory? = null
  var entityManager: EntityManager? = entityManagerFactory?.createEntityManager()
  var dbConfig = ApplicationConfigProvider().getConfigData().dbConfig

  fun initConnect() {
    if ((entityManagerFactory == null) || (!entityManagerFactory?.isOpen!!)) {

    }
    val properties: Map<String?, String?> = object : HashMap<String?, String?>() {
      init {
        put(JPA_JDBC_URL, dbConfig.getConnectionUrlWithSchema())
        put(JPA_JDBC_USER, dbConfig.user)
        put(JPA_JDBC_PASSWORD, dbConfig.password)
      }
    }

    entityManagerFactory = Persistence.createEntityManagerFactory(dbConfig.schema, properties)
  }

  fun getConnection(): EntityManager? {
    return entityManagerFactory?.createEntityManager();
  }

  fun close() {
    entityManagerFactory?.close()
  }
}