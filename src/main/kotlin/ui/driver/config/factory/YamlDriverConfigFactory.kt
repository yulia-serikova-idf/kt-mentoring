package ui.driver.config.factory

import app.config.model.ConfigExtensionType
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.provider.TafProperties
import context.constant.application.TafConfig
import ui.driver.config.model.DriverConfig

class YamlDriverConfigFactory() : BaseConfigFactory(
  ConfigExtensionType.YAML,
  TafProperties.READ_CONFIG_DRIVER_FILE_NAME,
  YAMLFactory()
) {
  override fun getConfig(): TafConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, DriverConfig::class.java)
    }
  }
}