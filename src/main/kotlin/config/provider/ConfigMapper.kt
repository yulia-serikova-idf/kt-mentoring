package config.provider

import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionTypes
import config.model.LoginConfig

class ConfigMapper {
  fun getConfigData(configExtensionTypes: ConfigExtensionTypes?): LoginConfig {
    return when (configExtensionTypes) {
      ConfigExtensionTypes.JSON -> JsonConfigFactory().getConfig()
      ConfigExtensionTypes.YAML -> YamlConfigFactory().getConfig()
      else -> throw java.lang.IllegalArgumentException("wrong extension")
    }
  }
}