package config.factory.driver

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.model.ConfigExtensionType
import config.model.DriverConfig
import config.model.TafConfig
import config.provider.TafProperties

class YamlDriverConfigFactory() : BaseConfigFactory(
  ConfigExtensionType.YAML,
  TafProperties.READ_CONFIG_FILE_NAME,
  YAMLFactory()
) {
  override fun getConfig(): TafConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, DriverConfig::class.java)
    }
  }
}