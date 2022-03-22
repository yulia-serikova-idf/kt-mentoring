package config.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ui.driver.config.model.DriverConfig
import ui.driver.config.provider.DriverConfigProvider

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