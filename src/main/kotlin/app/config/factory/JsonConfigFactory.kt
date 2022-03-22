package app.config.factory

import app.config.model.ConfigExtensionType.JSON
import com.fasterxml.jackson.core.JsonFactory
import config.factory.BaseConfigFactory
import config.provider.TafProperties

class JsonConfigFactory() : BaseConfigFactory(JSON, TafProperties.READ_CONFIG_FILE_NAME, JsonFactory())