package com

import config.model.ConfigExtensionTypes
import config.provider.ConfigMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class LoginConfigTest {

  @ParameterizedTest
  @EnumSource(value = ConfigExtensionTypes::class, names = ["JSON", "YAML"], mode = EnumSource.Mode.INCLUDE)
  fun compare_host_by_params(extensionTypes: ConfigExtensionTypes) {
    val login = ConfigMapper().getConfigData(extensionTypes)
    Assertions.assertEquals(login.host, "qa-delivery-ru-release.moneyman.ru")
  }
}