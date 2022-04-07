package context.dynamic.session

class JSessionIdContext : SessionContext() {
  var jSessionCookie: Pair<String, String>? = null
}