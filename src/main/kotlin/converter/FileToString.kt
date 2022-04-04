package converter

object FileToString {
  fun getMockDataFromFileToString(path: String): String {
    return Thread.currentThread().contextClassLoader
      .getResourceAsStream(path).readBytes().toString(Charsets.UTF_8)
  }
}