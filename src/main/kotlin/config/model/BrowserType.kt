package config.model

import com.fasterxml.jackson.annotation.JsonValue

enum class BrowserType(@JsonValue val browserType: String) {
  CHROME("chrome"), FIREFOX("firefox")
}