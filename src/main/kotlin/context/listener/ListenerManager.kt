package context.listener

open class ListenerManager {
  open val listeners: MutableList<Listener> = mutableListOf()

  fun addListener(listener: Listener) {
    listeners.add(listener)
  }

  fun removeListener(listener: Listener) {
    listeners.remove(listener)
  }

  fun notifyOnChange() {
    listeners.forEach { it.updateState() }
  }
}