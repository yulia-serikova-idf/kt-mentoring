package mock.config.model

import config.model.TafConfig

data class MockConfig(
  val host: String,
  val port: Int
) : TafConfig