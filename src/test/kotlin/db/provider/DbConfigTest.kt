package db.provider

import context.constant.application.DbConfig
import context.constant.provider.ApplicationConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DbConfigTest {
  @Test
  fun `verify ApplicationConfigProvider returns db connection config`() {
    val dbConfig: DbConfig = ApplicationConfigProvider().getConfigData().dbConfig
    Assertions.assertNotNull(dbConfig)
  }
}