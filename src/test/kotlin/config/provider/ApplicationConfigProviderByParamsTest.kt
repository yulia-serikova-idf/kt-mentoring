package config.provider

import app.config.factory.JsonConfigFactory
import app.config.factory.YamlConfigFactory
import app.config.model.ConfigExtensionType.JSON
import context.constant.provider.ApplicationConfigProvider
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