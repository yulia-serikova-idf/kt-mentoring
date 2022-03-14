package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import config.model.ApplicationConfig
import java.nio.file.Path

interface ConfigFactory {
  var mapper: ObjectMapper
  var path: Path
  fun getConfig(): ApplicationConfig
}