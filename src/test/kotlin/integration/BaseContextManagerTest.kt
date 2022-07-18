package integration

import context.constant.TafStaticContext
import context.constant.TafStaticContextHolder
import context.dynamic.TafDynamicContext
import context.dynamic.TafDynamicContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseContextManagerTest {

  @BeforeAll
  fun createContext() {
    TafStaticContextHolder.setContext(TafStaticContext())
    TafDynamicContextHolder.setContext(TafDynamicContext())
  }

  @AfterAll
  fun cleanup() {
    TafStaticContextHolder.clearContext()
    TafDynamicContextHolder.clearContext()
  }
}