package com

import config.model.ConfigExtensionType
import config.provider.ConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ApplicationConfigTest {

  @ParameterizedTest
  @EnumSource(value = ConfigExtensionType::class, names = ["XML"], mode = EnumSource.Mode.EXCLUDE)
  fun compare_host_by_params(extensionTypes: ConfigExtensionType) {
    val config = ConfigProvider().getConfigData(extensionTypes)
    Assertions.assertNotNull(config)
  }
}