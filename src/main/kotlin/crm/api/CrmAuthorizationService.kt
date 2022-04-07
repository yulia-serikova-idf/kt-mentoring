package crm.api

import crm.api.model.CrmUserRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CrmAuthorizationService {
  @POST("/secure/rest/sign/in")
  fun postCrmAuthorization(
    @Body body: CrmUserRequest
  ): Call<ResponseBody>
}