package config.factory

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.model.ApplicationConfig
import config.model.TafConfig
import config.model.ConfigExtensionType
import config.utils.AppConfigReader.getConfigParam
import java.nio.file.Path
import java.nio.file.Paths

abstract class BaseConfigFactory(
  configExtensionType: ConfigExtensionType,
  configFileName: String,
  factory: JsonFactory,
  val path: Path = Paths.get(getConfigParam(configFileName) + configExtensionType.extension)
) : ConfigFactory {

  val mapper: ObjectMapper = ObjectMapper(factory).registerModule(KotlinModule())

  override fun getConfig(): TafConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, ApplicationConfig::class.java)
    }
  }
}