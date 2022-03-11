package config.provider

import config.factory.ConfigFactory
import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType
import config.model.ApplicationConfig

class ConfigProvider {

  private fun getConfigFactory(configExtensionType: ConfigExtensionType): ConfigFactory {
    return when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonConfigFactory()
      ConfigExtensionType.YAML -> YamlConfigFactory()
      ConfigExtensionType.XML -> throw java.lang.IllegalArgumentException("xml extension is not allowed now")
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType): ApplicationConfig {
    return getConfigFactory(configExtensionType).getConfig()
  }
}