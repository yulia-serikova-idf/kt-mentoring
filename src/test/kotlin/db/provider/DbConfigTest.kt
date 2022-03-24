package db.provider

import db.config.provider.DbConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DbConfigTest {
  @Test
  fun `verify db config connection`() {
    Assertions.assertNotNull(DbConfigProvider().getConfigData())
  }
}