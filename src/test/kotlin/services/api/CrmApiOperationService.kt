package services.api

import context.constant.application.CrmUser
import crm.api.CrmUserAuthorizationController
import crm.api.model.CrmUserResponse

class CrmApiOperationService(private val baseUrl: String, private val crmUser: CrmUser) {

  fun getResponseCrmUserAuthorization(): CrmUserResponse {
    return CrmUserAuthorizationController(baseUrl, crmUser).authCrm()
  }

  /**
   * TODO ENUM
   */
  fun getJSessionAuthorisationCookie(cookieName: String = "JSESSIONID"): Map<String, String> {
    return mapOf(
      cookieName to getResponseCrmUserAuthorization().cookiesResponse
        .getCookieByName(cookieName)!!
    )
  }
}