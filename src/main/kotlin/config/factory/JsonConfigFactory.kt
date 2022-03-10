package config.factory

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.model.ConfigExtensionTypes
import config.model.LoginConfig
import config.provider.Properties
import java.nio.file.Files
import java.nio.file.Paths

class JsonConfigFactory : IConfigFactory {
  override fun getConfig(): LoginConfig {
    val mapper = ObjectMapper(JsonFactory()).registerModule(KotlinModule())
    val path = Paths.get(Properties.conf_path + ConfigExtensionTypes.JSON.extension)
    return Files.newBufferedReader(path).use {
      mapper.readValue(it, LoginConfig::class.java)
    }
  }
}