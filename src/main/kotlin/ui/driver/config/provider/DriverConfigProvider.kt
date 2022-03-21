package ui.driver.config.provider

import ui.driver.config.factory.YamlDriverConfigFactory
import ui.driver.config.model.DriverConfig

class DriverConfigProvider {
  fun getConfigData(): DriverConfig = YamlDriverConfigFactory().getConfig() as DriverConfig
}