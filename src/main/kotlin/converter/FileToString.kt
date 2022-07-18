package converter

object FileToString {
  fun getFileAsString(path: String): String {
    return Thread.currentThread().contextClassLoader
      .getResourceAsStream(path).readBytes().toString(Charsets.UTF_8)
  }
}