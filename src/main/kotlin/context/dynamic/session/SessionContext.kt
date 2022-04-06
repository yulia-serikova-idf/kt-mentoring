package context.dynamic.session

import context.listener.Listener
import context.listener.ListenerManager
import context.listener.SessionContextListener
import http.model.response.TafResponse

abstract class SessionContext : ListenerManager() {
  override var listeners: ArrayList<Listener> = ArrayList()

  init {
    this.addListener(SessionContextListener())
  }

  var contextResponse: TafResponse? = null
    set(value) {
      field = value
      notifyOnChange()
    }
}