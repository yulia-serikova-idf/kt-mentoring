package context

import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.dynamic.TafDynamicContext
import context.dynamic.TafDynamicContextHolder

internal fun staticContext(): TafStaticContext = TafStaticContextHolder.getContext()
internal fun contextApplicationConfig() = staticContext().applicationConfig

val dynamicContext: TafDynamicContext = TafDynamicContextHolder.getContext()
var jSessionCookie: Map<String, String>? = dynamicContext.sessionContext.jSessionCookie