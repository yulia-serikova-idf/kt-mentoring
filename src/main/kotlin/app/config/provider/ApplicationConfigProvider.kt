package app.config.provider

import app.config.factory.JsonConfigFactory
import app.config.factory.YamlConfigFactory
import app.config.model.ApplicationConfig
import app.config.model.ConfigExtensionType
import app.config.model.ConfigExtensionType.valueOf
import config.factory.ConfigFactory
import config.provider.TafProperties
import config.provider.TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY
import config.utils.AppConfigReader.getConfigParam
import org.slf4j.LoggerFactory

class ApplicationConfigProvider {
  private var logger = LoggerFactory.getLogger(ApplicationConfigProvider::class.java)

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
        logger.info("Extension by system property $finalConfigFileType")
        getConfigFactory(finalConfigFileType)
      }
    }
  }

  fun getConfigData(configExtensionType: ConfigExtensionType? = null): ApplicationConfig {
    logger.info("Create ApplicationConfig using ${configExtensionType?.name}")
    return getConfigFactory(configExtensionType).getConfig() as ApplicationConfig
  }
}