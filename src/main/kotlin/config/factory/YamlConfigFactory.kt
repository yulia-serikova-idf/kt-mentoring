package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import config.model.ConfigExtensionTypes
import config.model.LoginConfig
import config.provider.Properties
import java.nio.file.Files

import java.nio.file.Paths

class YamlConfigFactory : IConfigFactory {
  override fun getConfig(): LoginConfig {
    val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val path = Paths.get(Properties.conf_path + ConfigExtensionTypes.YAML.extension)
    return Files.newBufferedReader(path).use {
      mapper.readValue(it, LoginConfig::class.java)
    }
  }
}