package config.utils

import java.util.Properties

class AppConfigReader {
  companion object {
    fun getConfigParam(configName: String): String {
      val prop = Properties()
      Thread.currentThread().contextClassLoader.getResourceAsStream("application/app.properties").use {
        prop.load(it)
        return prop[configName].toString()
      }
    }
  }
}