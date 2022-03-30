package crm.api

import crm.api.model.CrmUserRequest
import crm.api.model.CrmUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CrmAuthorizationService {
  @POST("/secure/rest/sign/in")
  fun postCrmAuthorization(
    @Body body: CrmUserRequest
  ): Call<CrmUserResponse>
}