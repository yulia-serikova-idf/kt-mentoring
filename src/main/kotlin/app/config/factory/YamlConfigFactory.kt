package app.config.factory

import app.config.model.ConfigExtensionType.YAML
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.provider.TafProperties

class YamlConfigFactory() : BaseConfigFactory(YAML, TafProperties.READ_CONFIG_FILE_NAME, YAMLFactory())