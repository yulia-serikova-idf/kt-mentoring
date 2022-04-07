package crm.api

import context.contextApplicationConfig
import context.dynamic.TafDynamicContextHolder
import crm.api.model.CrmUserRequest
import http.model.response.TafResponse
import http.retrofit.RetrofitClient

class CrmUserAuthorizationController(private val baseUrl: String) {
  private val service: CrmAuthorizationService = RetrofitClient()
    .getClient(baseUrl)
    .create(CrmAuthorizationService::class.java)

  fun authCrm(): TafResponse {
    val crmUserRequest = CrmUserRequest(contextApplicationConfig().crmUser)
    val authTafResponse = TafResponse(service.postCrmAuthorization(crmUserRequest).execute())
    TafDynamicContextHolder.getContext().sessionContext.contextResponse = authTafResponse
    return authTafResponse
  }
}