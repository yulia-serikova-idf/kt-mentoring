package config.factory.app

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.model.ConfigExtensionType.YAML
import config.provider.TafProperties

class YamlConfigFactory() : BaseConfigFactory(YAML, TafProperties.READ_CONFIG_FILE_NAME, YAMLFactory())