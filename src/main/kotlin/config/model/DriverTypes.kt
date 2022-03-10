package config.model

import com.fasterxml.jackson.annotation.JsonValue

enum class DriverTypes(@JsonValue val str: String) {
  LOCAL("local"), REMOTE("remote")
}