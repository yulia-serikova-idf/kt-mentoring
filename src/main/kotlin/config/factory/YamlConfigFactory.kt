package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import config.model.ConfigExtensionType.YAML
import java.nio.file.Path

class YamlConfigFactory() : BaseConfigFactory(YAML) {
  override lateinit var mapper: ObjectMapper
  override lateinit var path: Path
}