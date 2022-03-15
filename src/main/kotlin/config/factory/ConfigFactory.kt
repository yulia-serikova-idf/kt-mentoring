package config.factory

import config.model.ApplicationConfig

interface ConfigFactory {
  fun getConfig(): ApplicationConfig
}