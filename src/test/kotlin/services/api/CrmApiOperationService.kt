package services.api

import context.contextApplicationConfig
import crm.api.CrmUserAuthorizationController
import crm.api.model.CrmUserResponse

class CrmApiOperationService(private val baseUrl: String = contextApplicationConfig().getBaseUrl()) {

  fun getResponseCrmUserAuthorization(): CrmUserResponse {
    return CrmUserAuthorizationController(baseUrl).authCrm()
  }

  fun getCrmUserResponse(): CrmUserResponse {
    return getResponseCrmUserAuthorization()
  }
}