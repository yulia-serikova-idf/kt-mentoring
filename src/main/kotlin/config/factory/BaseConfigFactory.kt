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

abstract class BaseConfigFactory() : ConfigFactory {
  abstract override var mapper: ObjectMapper
  abstract override var path: Path

  constructor(configExtensionType: ConfigExtensionType) : this() {
    this.path = Paths.get(getConfigParam(READ_CONFIG_FILE_NAME) + configExtensionType.extension)
    when (configExtensionType) {
      ConfigExtensionType.JSON -> this.mapper = ObjectMapper(JsonFactory()).registerModule(KotlinModule())
      ConfigExtensionType.YAML -> this.mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    }
  }

  override fun getConfig(): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, ApplicationConfig::class.java)
    }
  }
}