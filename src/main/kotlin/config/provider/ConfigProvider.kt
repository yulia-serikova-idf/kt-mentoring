package config.provider

import config.factory.ConfigFactory
import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType
import config.model.ConfigExtensionType.valueOf
import config.model.ApplicationConfig

class ConfigProvider {

  fun getConfigFactory(configExtensionType: ConfigExtensionType?): ConfigFactory {

    return when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonConfigFactory()
      ConfigExtensionType.YAML -> YamlConfigFactory()
      else -> getConfigFactory(valueOf(System.getProperty("CONFIG_RES_FILETYPE", "JSON")))
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType): ApplicationConfig {
    return getConfigFactory(configExtensionType).getConfig()
  }
}