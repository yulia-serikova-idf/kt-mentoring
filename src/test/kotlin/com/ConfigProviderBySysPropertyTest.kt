package com

import config.factory.YamlConfigFactory
import config.provider.ConfigProvider
import config.provider.TafProperties
import config.utils.AppConfigReader
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConfigProviderBySysPropertyTest {

  @BeforeEach
  fun init() {
    System.setProperty(
      TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY,
      AppConfigReader.getConfigParam(TafProperties.READ_CONFIG_FILE_TYPE)
    )
  }

  @Test
  fun `compare factory by system property`() {
    Assertions.assertEquals(ConfigProvider().getConfigFactory(null)::class, YamlConfigFactory::class)
  }

  @AfterEach
  fun tearDown() {
    System.clearProperty(TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY)
  }
}