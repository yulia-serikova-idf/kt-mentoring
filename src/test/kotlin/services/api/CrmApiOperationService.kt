package services.api

import context.contextApplicationConfig
import crm.api.CrmUserAuthorizationController
import crm.api.model.CrmUserResponse
import http.model.response.TafResponse

class CrmApiOperationService(private val baseUrl: String = contextApplicationConfig().getBaseUrl()) {

  fun getResponseCrmUserAuthorization(): TafResponse {
    return CrmUserAuthorizationController(baseUrl).authCrm()
  }

  fun getCrmUserResponse(): CrmUserResponse {
    return getResponseCrmUserAuthorization().convertBodyToObj(CrmUserResponse::class.java)
  }
}