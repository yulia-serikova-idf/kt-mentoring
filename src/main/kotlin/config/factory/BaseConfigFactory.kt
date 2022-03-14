package config.factory

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.model.ApplicationConfig
import config.model.ConfigExtensionType
import config.provider.TafProperties.READ_CONFIG_FILE_NAME
import config.utils.AppConfigReader.getConfigParam
import java.nio.file.Path
import java.nio.file.Paths

open class BaseConfigFactory() : ConfigFactory {
  final override lateinit var mapper: ObjectMapper
  final override lateinit var path: Path

  constructor(configExtensionType: ConfigExtensionType) : this() {
    path = Paths.get(getConfigParam(READ_CONFIG_FILE_NAME) + configExtensionType.extension)
    val factory: JsonFactory = when (configExtensionType) {
      ConfigExtensionType.JSON -> JsonFactory()
      ConfigExtensionType.YAML -> YAMLFactory()
    }
    mapper = ObjectMapper(factory).registerModule(KotlinModule())
  }

  override fun getConfig(): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, ApplicationConfig::class.java)
    }
  }
}