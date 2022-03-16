package config.factory

import config.model.Config

interface ConfigFactory {
  fun getConfig(): Config
}