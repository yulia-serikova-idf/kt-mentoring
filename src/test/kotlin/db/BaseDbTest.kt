package db

import db.util.TafConnectorUtil
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseDbTest {

  @BeforeAll
  fun initDb() {
    TafConnectorUtil().getSession()
  }

  @AfterAll
  fun closeDb() {
    TafConnectorUtil().closeSessions()
  }
}