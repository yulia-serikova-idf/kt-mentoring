package context.listener

import context.dynamicContext
import http.model.CookieNameType

class SessionContextListener(
  private val cookieName: String = CookieNameType.JSESSIONID.name
) : Listener {
  override fun updateState() {
    val cookieValue: String? = dynamicContext().sessionContext.contextResponse?.getCookieByName(cookieName)
    cookieValue?.apply { dynamicContext().sessionContext.jSessionCookie = (cookieName to this) }
  }
}