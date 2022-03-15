package config.provider

import config.factory.ConfigFactory
import config.factory.JsonConfigFactory
import config.factory.YamlConfigFactory
import config.model.ConfigExtensionType
import config.model.ConfigExtensionType.valueOf
import config.model.ApplicationConfig
import config.provider.TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY
import config.utils.AppConfigReader.getConfigParam
import org.slf4j.LoggerFactory

class ConfigProvider {
  private var logger = LoggerFactory.getLogger(ConfigProvider::class.java)

  fun getConfigFactory(configExtensionType: ConfigExtensionType? = null): ConfigFactory {
    return when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonConfigFactory()
      ConfigExtensionType.YAML -> YamlConfigFactory()
      else -> {
        logger.info("Get factory by sys.property, in param was $configExtensionType")
        val defaultConfigFileType = getConfigParam(TafProperties.READ_CONFIG_FILE_TYPE)
        logger.info("Extension by file $defaultConfigFileType")
        val finalConfigFileType = valueOf(
          System.getProperty(CONFIG_FILETYPE_SYSTEM_PROPERTY, defaultConfigFileType)
        )
        logger.info("Extension by system property $defaultConfigFileType")
        getConfigFactory(finalConfigFileType)
      }
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType? = null): ApplicationConfig {
    logger.info("Create ApplicationConfig using ${configExtensionType?.name}")
    return getConfigFactory(configExtensionType).getConfig()
  }
}