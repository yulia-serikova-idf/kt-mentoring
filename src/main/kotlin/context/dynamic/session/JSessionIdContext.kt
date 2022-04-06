package context.dynamic.session

class JSessionIdContext : SessionContext() {
  var jSessionCookie: Map<String, String>? = null
}