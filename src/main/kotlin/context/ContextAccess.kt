package context

import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.dynamic.TafDynamicContext
import context.dynamic.TafDynamicContextHolder

internal fun staticContext(): TafStaticContext = TafStaticContextHolder.getContext()
internal fun contextApplicationConfig() = staticContext().applicationConfig
internal fun dynamicContext(): TafDynamicContext = TafDynamicContextHolder.getContext()
internal fun jSessionCookie(): Pair<String, String>? = dynamicContext().sessionContext.jSessionCookie