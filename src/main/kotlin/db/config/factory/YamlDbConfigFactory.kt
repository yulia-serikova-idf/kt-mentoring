package db.config.factory

import app.config.model.ConfigExtensionType
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.model.TafConfig
import config.provider.TafProperties
import db.config.model.DbConfig

class YamlDbConfigFactory() : BaseConfigFactory(
  ConfigExtensionType.YAML,
  TafProperties.READ_CONFIG_DB_FILE_NAME,
  YAMLFactory()
) {
  override fun getConfig(): TafConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, DbConfig::class.java)
    }
  }
}