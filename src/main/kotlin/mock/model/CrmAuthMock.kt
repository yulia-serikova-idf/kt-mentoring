package mock.model

import com.github.tomakehurst.wiremock.client.MappingBuilder
import java.util.*

data class CrmAuthMock(
  override var id: UUID? = null,
  override val priority: Int = 1,
  override val mockName: String = "crm_sign_in",
  override val mockEndpoint: String = "/secure/rest/sign/in",
  override val status: Int = 200,
  override var mappingBuilder: MappingBuilder? = null,
  override val responseFilePath: String? = "mock_responses/response200CrmSignIn.json",
  override var header: Map<String, String> = mapOf("Set-Cookie" to "JSESSIONID=12345"),
  override var body: String? = null,
) : TafMock