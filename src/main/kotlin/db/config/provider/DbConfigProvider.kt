package db.config.provider

import db.config.factory.YamlDbConfigFactory
import db.config.model.DbConfig

class DbConfigProvider {
  fun getConfigData(): DbConfig = YamlDbConfigFactory().getConfig() as DbConfig
}