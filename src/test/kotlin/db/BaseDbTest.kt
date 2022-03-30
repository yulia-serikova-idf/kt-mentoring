package db

import db.util.TafDbClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseDbTest {

  @BeforeAll
  fun initDb() {
    TafDbClient().getSession()
  }

  @AfterAll
  fun closeDb() {
    TafDbClient().closeSessions()
  }
}