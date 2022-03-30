package crm.api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import http.model.response.TafResponse

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrmUserResponse(
  val id: Int,
  val userName: String
) {
  lateinit var cookiesResponse: TafResponse //bad =\
}