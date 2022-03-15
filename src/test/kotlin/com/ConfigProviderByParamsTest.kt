package com

import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType.JSON
import config.provider.ConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConfigProviderByParamsTest {

  @Test
  fun `compare factory by file param in param null`() {
    Assertions.assertEquals(ConfigProvider().getConfigFactory(null)::class, YamlConfigFactory::class)
  }

  @Test
  fun `compare factory by JSON in param`() {
    Assertions.assertEquals(ConfigProvider().getConfigFactory(JSON)::class, JsonConfigFactory::class)
  }
}