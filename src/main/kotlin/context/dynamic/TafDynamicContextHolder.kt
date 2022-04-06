package context.dynamic

import context.TafContextHolder

object TafDynamicContextHolder : TafContextHolder<TafDynamicContext> {
  override var tafContext: TafDynamicContext? = null
}