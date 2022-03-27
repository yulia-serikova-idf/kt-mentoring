package crm.config.factory

import app.config.model.ConfigExtensionType
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import config.factory.BaseConfigFactory
import config.model.TafConfig
import config.provider.TafProperties
import crm.config.model.CrmUser

class YamlConfigCrmUserFactory() : BaseConfigFactory(
  ConfigExtensionType.YAML,
  TafProperties.READ_CONFIG_FILE_NAME,
  YAMLFactory()
) {
  override fun getConfig(): TafConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(path.toString()).use {
      mapper.readValue(it, CrmUser::class.java)
    }
  }
}