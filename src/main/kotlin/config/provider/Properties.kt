package config.provider

object Properties {
  val conf_mode: String = System.getProperty("config.mode")
  val conf_path: String = System.getProperty("config.path")
}