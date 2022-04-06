package context.dynamic

import context.TafContext
import context.dynamic.session.JSessionIdContext

class TafDynamicContext : TafContext {
  val sessionContext: JSessionIdContext = JSessionIdContext()
}