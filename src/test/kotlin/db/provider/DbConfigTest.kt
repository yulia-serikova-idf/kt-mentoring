package db.provider

import app.config.provider.ApplicationConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DbConfigTest {
  @Test
  fun `verify db config connection`() {
    Assertions.assertNotNull(ApplicationConfigProvider().getConfigData().dbConfig)
  }
}