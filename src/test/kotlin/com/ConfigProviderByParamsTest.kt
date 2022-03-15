package com

import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType.JSON
import config.provider.ConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConfigProviderByParamsTest {

  @Test
  fun `getConfigFactory returns factory using default config file type when file param is null`() {
    Assertions.assertEquals(ConfigProvider().getConfigFactory()::class, YamlConfigFactory::class)
  }

  @Test
  fun `getConfigFactory returns factory using ConfigExtensionType param`() {
    Assertions.assertEquals(ConfigProvider().getConfigFactory(JSON)::class, JsonConfigFactory::class)
  }
}