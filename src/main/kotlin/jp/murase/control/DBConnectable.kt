package jp.murase.control

import org.jetbrains.exposed.sql.Table

interface DBConnectable {
    fun establish(url: String, driver: String):DBController
    fun createSchema(tableName: String, table: Table): DBController
    fun insertData(tableName: String, schemeName: String, data: Any): DBController
    fun selectData(tableName: String): DBController
    fun updateData(tableName: String) :DBController
    fun deleteData(tableName: String) :DBController
    fun disConnection() :Boolean
}
