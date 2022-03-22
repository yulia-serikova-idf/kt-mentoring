package config.factory

import config.model.TafConfig

interface ConfigFactory {
  fun getConfig(): TafConfig
}