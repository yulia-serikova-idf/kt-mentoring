package crm.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import config.model.TafConfig

@JsonIgnoreProperties(ignoreUnknown = true)
data class CrmUser(
  @JsonInclude(JsonInclude.Include.NON_NULL)
  val login: String,
  val password: String,
  val role: String,
  val captcha: String
) : TafConfig