package ui.driver.factory

import ui.driver.config.model.DriverConfig

interface DriverFactory {
  fun setDriver(driverConfig: DriverConfig)
}