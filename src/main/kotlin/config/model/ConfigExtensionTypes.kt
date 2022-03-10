package config.model

enum class ConfigExtensionTypes(val extension: String) {
  YAML(".yaml"), JSON(".json");

  companion object {
    fun getByValue(value: String) = values().find { it.extension == value }
  }
}