package services.api

import crm.api.CrmUserAuthorizationController
import http.model.response.TafResponse

class CrmApiOperationService(private val baseUrl: String) {

  fun getResponseCrmUserAuthorization(): TafResponse {
    return CrmUserAuthorizationController(baseUrl).authCrm()
  }

  /**
   * TODO ENUM
   */
  fun getJSessionAuthorisationCookie(cookieName: String = "JSESSIONID"): Pair<String, String> {
    return (cookieName to getResponseCrmUserAuthorization().getCookieByName(cookieName)!!)
  }
}