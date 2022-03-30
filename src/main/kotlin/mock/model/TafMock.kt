package mock.model

import com.github.tomakehurst.wiremock.client.MappingBuilder
import java.util.*

interface TafMock {
  var id: UUID?
  val priority: Int?
  val mockName: String?
  val mockEndpoint: String
  var mappingBuilder: MappingBuilder?
  val status: Int?
  val responseFilePath: String?
  var header: Map<String, String>
  val body: String?
}