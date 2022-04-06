package config.factory

import context.constant.application.TafConfig

interface ConfigFactory {
  fun getConfig(): TafConfig
}