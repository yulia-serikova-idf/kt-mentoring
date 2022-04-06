package config.factory

import app.config.model.ConfigExtensionType
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.utils.AppConfigReader.getConfigParam
import context.constant.application.ApplicationConfig
import context.constant.application.TafConfig
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