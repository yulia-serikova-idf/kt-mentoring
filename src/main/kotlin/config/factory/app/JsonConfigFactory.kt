package config.factory.app

import com.fasterxml.jackson.core.JsonFactory
import config.factory.BaseConfigFactory
import config.model.ConfigExtensionType.JSON
import config.provider.TafProperties

class JsonConfigFactory() : BaseConfigFactory(JSON, TafProperties.READ_CONFIG_FILE_NAME,  JsonFactory())