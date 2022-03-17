package config.model

import config.provider.DriverConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DriverConfigTest {

  @Test
  fun `Create DriverConfig and compare non null`() {
    Assertions.assertNotNull(DriverConfigProvider().getConfigData())
  }

  @Test
  fun `Create DriverConfig and compare instance`() {
    Assertions.assertEquals(DriverConfigProvider().getConfigData()::class.java, DriverConfig::class.java)
  }
}