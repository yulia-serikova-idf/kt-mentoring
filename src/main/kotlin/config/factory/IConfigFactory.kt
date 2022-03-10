package config.factory

import config.model.LoginConfig

interface IConfigFactory {
  fun getConfig(): LoginConfig
}