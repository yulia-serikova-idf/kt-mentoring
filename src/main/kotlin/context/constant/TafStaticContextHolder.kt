package context.constant

import context.TafContextHolder

object TafStaticContextHolder : TafContextHolder<TafStaticContext> {
  override var tafContext: TafStaticContext? = null
}