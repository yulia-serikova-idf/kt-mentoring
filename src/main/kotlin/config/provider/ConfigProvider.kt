package config.provider

import config.factory.ConfigFactory
import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType
import config.model.ConfigExtensionType.valueOf
import config.model.ApplicationConfig
import config.provider.TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY
import config.utils.AppConfigReader.getConfigParam

class ConfigProvider {

  fun getConfigFactory(configExtensionType: ConfigExtensionType? = null): ConfigFactory {
    return when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonConfigFactory()
      ConfigExtensionType.YAML -> YamlConfigFactory()
      else -> {
        val defaultConfigFileType = getConfigParam(TafProperties.READ_CONFIG_FILE_TYPE)
        val finalConfigFileType = valueOf(
          System.getProperty(CONFIG_FILETYPE_SYSTEM_PROPERTY, defaultConfigFileType)
        )
        getConfigFactory(finalConfigFileType)
      }
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType? = null): ApplicationConfig {
    return getConfigFactory(configExtensionType).getConfig()
  }
}