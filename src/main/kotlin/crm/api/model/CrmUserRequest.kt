package crm.api.model

import crm.config.model.CrmUser

data class CrmUserRequest(
  var login: String,
  var password: String,
  var captcha: String
) {

  constructor(user: CrmUser) : this(
    login = user.login,
    password = user.password,
    captcha = user.captcha
  )
}