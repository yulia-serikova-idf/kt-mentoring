package crm.api

import context.contextApplicationConfig
import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import http.retrofit.RetrofitClient

class CrmUserAuthorizationController(private val baseUrl: String) {
  private val service: CrmAuthorizationService = RetrofitClient()
    .getClient(baseUrl)
    .create(CrmAuthorizationService::class.java)

  fun authCrm(): CrmUserResponse {
    val crmUserRequest = CrmUserRequest(contextApplicationConfig().crmUser)
    return service.postCrmAuthorization(crmUserRequest).execute().body()!!
  }
}