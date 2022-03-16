package config.factory.driver

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.model.Config
import config.model.ConfigExtensionType
import config.model.DriverConfig
import config.provider.TafProperties

class YamlDriverConfigFactory(): BaseConfigFactory(ConfigExtensionType.YAML, TafProperties.READ_DRIVER_CONFIG_FILE_NAME,
  YAMLFactory()) {

  override fun getConfig(): Config {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, DriverConfig::class.java)
    }
  }
}