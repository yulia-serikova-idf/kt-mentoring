package http.client
import http.model.response.TafResponseBody
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Request.Builder
import java.util.*

class CustomHttpClient(override var httpClient: OkHttpClient) : TafHttpClient {

  override fun get(path: String): TafResponseBody {
    TODO("Not yet implemented")
//    val request: Request = Builder()
//      .url(path)
//      .build()
//    client.newCall(request).execute().use { response -> return  }
  }

  override fun post() {
    TODO("Not yet implemented")
  }

  override fun delete() {
    TODO("Not yet implemented")
  }
}