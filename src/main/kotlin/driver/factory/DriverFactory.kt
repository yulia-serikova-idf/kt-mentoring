package driver.factory

import driver.model.DriverSettings

interface DriverFactory {
  fun setDriver(driver: DriverSettings)
}