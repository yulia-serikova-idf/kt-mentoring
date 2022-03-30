package services.api

import app.config.model.ApplicationConfig
import crm.api.CrmUserAuthorizationController
import crm.api.model.CrmUserResponse

class CrmApiOperationService(private val applicationConfig: ApplicationConfig) {

  fun getResponseCrmUserAuthorization(): CrmUserResponse {
    return CrmUserAuthorizationController(applicationConfig).authCrm()
  }

  fun getCookieValueFromCrmUserAuthorization(cookieName: String): String {
    return getResponseCrmUserAuthorization().cookiesResponse
      .getCookieByName(cookieName)!!
  }
}