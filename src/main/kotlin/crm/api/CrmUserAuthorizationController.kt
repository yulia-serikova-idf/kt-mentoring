package crm.api

import app.config.model.ApplicationConfig
import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import crm.config.model.CrmUser

import http.retrofit.RetrofitClient

class CrmUserAuthorizationController(private val applicationConfig: ApplicationConfig) {
  private val service: CrmAuthorizationService = RetrofitClient()
    .getClient(applicationConfig.getBaseUrl())
    .create(CrmAuthorizationService::class.java)
  private val crmUser: CrmUser = applicationConfig.crmUser

  fun authCrm(): CrmUserResponse {
    val crmUserRequest = CrmUserRequest(crmUser)
    return service.postCrmAuthorization(crmUserRequest).execute().body() ?: throw NullPointerException("empty body")
  }
}