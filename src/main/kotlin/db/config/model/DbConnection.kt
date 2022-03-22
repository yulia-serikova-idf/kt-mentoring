package db.config.model

import config.model.TafConfig

data class DbConnection(
  val url: String,
  val user: String,
  val password: String,
  val schema: String,
) : TafConfig