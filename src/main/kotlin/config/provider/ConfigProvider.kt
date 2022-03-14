package config.provider

import config.factory.ConfigFactory
import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType
import config.model.ConfigExtensionType.valueOf
import config.model.ApplicationConfig
import org.slf4j.LoggerFactory

class ConfigProvider {
  private var logger = LoggerFactory.getLogger(ConfigProvider::class.java)

  fun getConfigFactory(configExtensionType: ConfigExtensionType?): ConfigFactory {
    return when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonConfigFactory()
      ConfigExtensionType.YAML -> YamlConfigFactory()
      else -> {
        logger.warn("xml extension is not allowed now")
        getConfigFactory(valueOf(System.getProperty("CONFIG_RES_FILETYPE", "JSON")))
      }
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType): ApplicationConfig {
    logger.warn("In config provider, get factory")
    return getConfigFactory(configExtensionType).getConfig()
  }
}