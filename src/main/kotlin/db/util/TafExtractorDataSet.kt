package db.util

import com.vladsch.kotlin.jdbc.Row
import java.sql.ResultSet
import java.sql.ResultSetMetaData

object TafExtractorDataSet {
  val extractRow: (Row) -> HashMap<String, Any> = { row ->
    val resultSet: ResultSet = row.rs
    val metaData: ResultSetMetaData = resultSet.metaData
    val column: HashMap<String, Any> = HashMap()
    for (i in 1..metaData.columnCount) {
      column.put(metaData.getColumnName(i), resultSet.getObject(i))
    }
    column
  }
}