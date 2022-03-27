package crm.api

import app.config.provider.ApplicationConfigProvider
import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import crm.config.model.CrmUser

import http.retrofit.RetrofitClient

class CrmUserAuthorizationController {
  private val service: CrmAuthorizationService = RetrofitClient
    .getClient(ApplicationConfigProvider().getConfigData().getBaseUrl())
    .create(CrmAuthorizationService::class.java)
  private val crmUser: CrmUser = ApplicationConfigProvider().getConfigData().crmUser

  fun authCrm(): CrmUserResponse {
    val crmUserRequest: CrmUserRequest = CrmUserRequest(crmUser)
      .getCrmUserRequest()
    return service.postCrmAuthorization(crmUserRequest).execute().body() ?: throw NullPointerException("empty body")
  }
}