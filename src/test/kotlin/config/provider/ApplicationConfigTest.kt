package config.provider

import app.config.model.ConfigExtensionType
import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.constant.application.ApplicationConfig
import context.constant.provider.ApplicationConfigProvider
import context.contextApplicationConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ApplicationConfigTest {

  @ParameterizedTest
  @EnumSource(value = ConfigExtensionType::class)
  fun `getConfigFactory returns factory using types from ConfigExtensionType`(extensionTypes: ConfigExtensionType) {
    val config = ApplicationConfigProvider().getConfigData(extensionTypes)
    Assertions.assertNotNull(config)
  }

  @Test
  fun `verify config object from context`() {
    TafStaticContextHolder.setContext(TafStaticContext())
    Assertions.assertEquals(contextApplicationConfig()::class, ApplicationConfig::class)
    TafStaticContextHolder.clearContext()
  }
}