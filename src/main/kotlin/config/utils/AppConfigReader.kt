package config.utils

import java.util.Properties

object AppConfigReader {
  private const val TAF_CONFIG_FILE = "application/app.properties"

  fun getConfigParam(configName: String): String {
    val prop = Properties()
    Thread.currentThread().contextClassLoader.getResourceAsStream(TAF_CONFIG_FILE).use {
      prop.load(it)
      return prop[configName].toString()
    }
  }
}