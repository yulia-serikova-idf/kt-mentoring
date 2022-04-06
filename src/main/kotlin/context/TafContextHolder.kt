package context

interface TafContextHolder<T : TafContext> {
  var tafContext: T?

  fun setContext(context: T) {
    if (tafContext == null) tafContext = context
  }

  fun getContext(): T {
    return tafContext ?: throw IllegalArgumentException("Context not initialisation")
  }

  fun clearContext() {
    tafContext = null
  }
}