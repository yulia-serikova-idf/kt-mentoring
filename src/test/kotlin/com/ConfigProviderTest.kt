package com

import config.model.ApplicationConfig
import config.model.ConfigExtensionType
import config.provider.ConfigProvider
import config.provider.TafProperties
import config.utils.AppConfigReader
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConfigProviderTest {

  private val CONFIG_RES_FILETYPE = "CONFIG_RES_FILETYPE"

  @BeforeEach
  fun init(){
    System.setProperty(CONFIG_RES_FILETYPE, AppConfigReader.getConfigParam(TafProperties.READ_CONFIG_FILE_TYPE))
  }

  @Test
  fun compare_config_by_sys_type() {
    val fileExtensionType = ConfigExtensionType.valueOf(System.getProperty("CONFIG_RES_FILETYPE", "XML"))
    Assertions.assertEquals(ConfigProvider().getConfigData(fileExtensionType)::class, ApplicationConfig::class)
  }

  @AfterEach
  fun tearDown(){
    System.clearProperty(CONFIG_RES_FILETYPE)
  }
}