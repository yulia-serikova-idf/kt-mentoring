package config.factory

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.model.ApplicationConfig
import config.model.ConfigExtensionType
import config.provider.TafProperties
import config.utils.AppConfigReader
import org.slf4j.LoggerFactory

import java.nio.file.Paths

class JsonConfigFactory : ConfigFactory {
  private var logger = LoggerFactory.getLogger(JsonConfigFactory::class.java)

  override fun getConfig(): ApplicationConfig {
    logger.info("Start create configs by json...")
    val mapper = ObjectMapper(JsonFactory()).registerModule(KotlinModule())
    val path = Paths.get(
      AppConfigReader.getConfigParam(TafProperties.READ_CONFIG_FILE_NAME)
          + ConfigExtensionType.JSON.extension
    )
      .toString()
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path).use {
      mapper.readValue(it, ApplicationConfig::class.java)
    }
  }
}