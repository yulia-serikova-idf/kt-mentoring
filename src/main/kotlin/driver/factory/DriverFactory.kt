package driver.factory

import config.model.DriverConfig

interface DriverFactory {
  fun setDriver(driverConfig: DriverConfig)
}