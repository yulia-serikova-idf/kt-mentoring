package db.provider

import app.config.provider.ApplicationConfigProvider
import db.config.model.DbConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DbConfigTest {
  @Test
  fun `verify ApplicationConfigProvider returns db connection config`() {
    val dbConfig: DbConfig = ApplicationConfigProvider().getConfigData().dbConfig
    Assertions.assertNotNull(dbConfig)
  }
}