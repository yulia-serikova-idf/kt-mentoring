package context.listener

import context.dynamicContext
import context.jSessionCookie

class SessionContextListener(
  private val cookieName: String = "JSESSIONID"
) : Listener {
  override fun updateState() {
    val cookieValue: String? = dynamicContext.sessionContext.contextResponse?.getCookieByName(cookieName)
    cookieValue?.apply { jSessionCookie = mapOf(cookieName to this) }
  }
}