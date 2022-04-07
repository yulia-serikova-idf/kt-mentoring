package context.listener

import context.dynamicContext

class SessionContextListener(
  private val cookieName: String = "JSESSIONID"
) : Listener {
  override fun updateState() {
    val cookieValue: String? = dynamicContext().sessionContext.contextResponse?.getCookieByName(cookieName)
    cookieValue?.apply { dynamicContext().sessionContext.jSessionCookie = (cookieName to this) }
  }
}