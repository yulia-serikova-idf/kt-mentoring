package mock.model

import java.util.*

interface TafMock {
  var id: UUID?
  val priority: Int?
  val mockName: String?
  val mockEndpoint: String
  val status: Int?
  val responseFilePath: String?
  var header: Map<String, String>
  val body: String?
}