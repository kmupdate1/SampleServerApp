package jp.murase.model

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

interface MetaDatabase {
    fun establish(url: String, driver: String): Unit
    fun createScheme(tableName: String, table: Table): Unit
    fun insertData(tableName: String, column: Column<Int>, data: Int): Unit
    fun insertData(tableName: String, column: Column<String>, data: String): Unit
    fun selectData(tableName: String): Unit
    fun updateData(tableName: String): Unit
    fun deleteData(tableName: String): Unit
    fun disConnection(): Unit
}
