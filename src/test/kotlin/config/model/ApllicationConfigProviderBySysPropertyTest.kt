package config.model

import app.config.factory.YamlConfigFactory
import app.config.provider.ApplicationConfigProvider
import config.provider.TafProperties
import config.utils.AppConfigReader
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApllicationConfigProviderBySysPropertyTest {

  @BeforeEach
  fun init() {
    System.setProperty(
      TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY,
      AppConfigReader.getConfigParam(TafProperties.READ_CONFIG_FILE_TYPE)
    )
  }

  @Test
  fun `getConfigFactory returns factory using system property config file type when file param is null`() {
    Assertions.assertEquals(ApplicationConfigProvider().getConfigFactory()::class, YamlConfigFactory::class)
  }

  @AfterEach
  fun tearDown() {
    System.clearProperty(TafProperties.CONFIG_FILETYPE_SYSTEM_PROPERTY)
  }
}