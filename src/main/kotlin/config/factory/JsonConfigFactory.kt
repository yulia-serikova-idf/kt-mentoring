package config.factory

import com.fasterxml.jackson.core.JsonFactory
import config.model.ConfigExtensionType.JSON

class JsonConfigFactory() : BaseConfigFactory(JSON, JsonFactory())