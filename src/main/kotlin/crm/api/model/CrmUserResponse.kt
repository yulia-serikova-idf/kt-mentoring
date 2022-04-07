package crm.api.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrmUserResponse(
  val id: Int,
  val userName: String
)