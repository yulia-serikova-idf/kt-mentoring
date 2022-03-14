package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import config.model.ConfigExtensionType.JSON
import java.nio.file.Path

class JsonConfigFactory() : BaseConfigFactory(JSON) {
  override lateinit var mapper: ObjectMapper
  override lateinit var path: Path
}