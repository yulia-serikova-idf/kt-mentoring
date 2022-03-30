package crm.api

import app.config.model.ApplicationConfig
import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import crm.config.model.CrmUser
import http.model.response.TafResponse

import http.retrofit.RetrofitClient

class CrmUserAuthorizationController(private val applicationConfig: ApplicationConfig) {
  private val service: CrmAuthorizationService = RetrofitClient()
    .getClient(applicationConfig.getBaseUrl())
    .create(CrmAuthorizationService::class.java)
  private val crmUser: CrmUser = applicationConfig.crmUser

  fun authCrm(): CrmUserResponse {
    val crmUserRequest = CrmUserRequest(crmUser)
    var crmUserResponse: CrmUserResponse = service.postCrmAuthorization(crmUserRequest).execute().body()!!
    crmUserResponse.cookiesResponse = TafResponse(service.postCrmAuthorization(crmUserRequest).execute().raw())
    return crmUserResponse
  }
}