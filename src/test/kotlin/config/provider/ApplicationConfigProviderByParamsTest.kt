package config.provider

import config.factory.app.JsonConfigFactory
import config.factory.app.YamlConfigFactory
import config.model.ConfigExtensionType.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationConfigProviderByParamsTest {

  @Test
  fun `getConfigFactory returns factory using default config file type when file param is null`() {
    Assertions.assertEquals(ApplicationConfigProvider().getConfigFactory()::class, YamlConfigFactory::class)
  }

  @Test
  fun `getConfigFactory returns factory using ConfigExtensionType param`() {
    Assertions.assertEquals(ApplicationConfigProvider().getConfigFactory(JSON)::class, JsonConfigFactory::class)
  }
}