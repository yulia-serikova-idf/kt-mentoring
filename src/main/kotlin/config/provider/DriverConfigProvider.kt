package config.provider

import config.factory.driver.YamlDriverConfigFactory
import config.model.DriverConfig

class DriverConfigProvider {
  fun getConfigData(): DriverConfig {
    return YamlDriverConfigFactory().getConfig() as DriverConfig
  }
}