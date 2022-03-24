package db.dao

import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.sqlQuery
import db.util.TafConnectorUtil
import java.sql.ResultSet
import java.sql.ResultSetMetaData

class TafStatementManager {
  private val session = TafConnectorUtil().getSession()

  private val extractRow: (Row) -> HashMap<String, Any> = { row ->
    val resultSet: ResultSet = row.rs
    val metaData: ResultSetMetaData = resultSet.metaData
    val column: HashMap<String, Any> = HashMap()
    for (i in 1..metaData.columnCount) {
      column.put(metaData.getColumnName(i), resultSet.getObject(i))
    }
    column
  }

  fun findAny(queryString: String, vararg param: Any): Map<String, Any> {
    val query = sqlQuery(queryString).params(params = param)
    return session.first(query, extractRow)!!
  }

  fun findAll(queryString: String, vararg param: Any): List<HashMap<String, Any>> {
    val query = sqlQuery(queryString).params(params = param)
    return session.list(query, extractRow)!!
  }
}