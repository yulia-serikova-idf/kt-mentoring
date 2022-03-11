package config.model

import com.fasterxml.jackson.annotation.JsonValue

enum class DriverType(@JsonValue val str: String) {
  LOCAL("local"), REMOTE("remote")
}