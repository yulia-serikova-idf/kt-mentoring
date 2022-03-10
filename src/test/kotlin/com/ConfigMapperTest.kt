package com

import config.model.ConfigExtensionTypes
import config.model.DriverTypes
import config.model.LoginConfig
import config.provider.ConfigMapper
import config.provider.Properties
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConfigMapperTest {

  @Test
  fun compare_config_by_sys_type() {
    val extensionType = Properties.conf_mode
    val loginExpected = LoginConfig("qa-delivery-ru-release.moneyman.ru", "moneyman", "1005", DriverTypes.LOCAL)
    val loginActual = ConfigMapper().getConfigData(ConfigExtensionTypes.getByValue(extensionType))
    Assertions.assertEquals(loginExpected, loginActual)
  }
}