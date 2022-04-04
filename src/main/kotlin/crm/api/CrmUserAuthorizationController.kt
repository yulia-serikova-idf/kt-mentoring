package crm.api

import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import crm.config.model.CrmUser
import http.model.response.TafResponse

import http.retrofit.RetrofitClient

class CrmUserAuthorizationController(private val baseUrl: String, private val crmUser: CrmUser) {
  private val service: CrmAuthorizationService = RetrofitClient()
    .getClient(baseUrl)
    .create(CrmAuthorizationService::class.java)

  fun authCrm(): CrmUserResponse {
    val crmUserRequest = CrmUserRequest(crmUser)
    val crmUserResponse: CrmUserResponse = service.postCrmAuthorization(crmUserRequest).execute().body()!!
    crmUserResponse.cookiesResponse = TafResponse(service.postCrmAuthorization(crmUserRequest).execute().raw())
    return crmUserResponse
  }
}