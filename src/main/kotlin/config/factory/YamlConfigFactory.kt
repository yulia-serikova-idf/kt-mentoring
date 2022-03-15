package config.factory

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.model.ConfigExtensionType.YAML

class YamlConfigFactory() : BaseConfigFactory(YAML, YAMLFactory())