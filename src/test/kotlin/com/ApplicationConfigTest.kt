package com

import config.model.ConfigExtensionType
import config.provider.ConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ApplicationConfigTest {

  @ParameterizedTest
  @EnumSource(value = ConfigExtensionType::class)
  fun `getConfigFactory returns factory using types from ConfigExtensionType`(extensionTypes: ConfigExtensionType) {
    val config = ConfigProvider().getConfigData(extensionTypes)
    Assertions.assertNotNull(config)
  }
}