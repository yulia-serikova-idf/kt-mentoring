package context.constant

import context.TafContext
import context.constant.application.ApplicationConfig
import context.constant.provider.ApplicationConfigProvider

class TafStaticContext : TafContext {
  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getConfigData()
}