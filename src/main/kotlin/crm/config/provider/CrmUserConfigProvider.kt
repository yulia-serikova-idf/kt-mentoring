package crm.config.provider

import crm.config.factory.YamlConfigCrmUserFactory
import crm.config.model.CrmUser

class CrmUserConfigProvider {
  fun getConfigData(): CrmUser = YamlConfigCrmUserFactory().getConfig() as CrmUser
}