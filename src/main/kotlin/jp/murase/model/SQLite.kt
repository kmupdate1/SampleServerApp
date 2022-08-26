package jp.murase.model

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

const val SQLITE = "SQLite"

class SQLite: MetaDatabase {
    private val tableMapList: MutableMap<String,Table> = mutableMapOf()

    override fun establish(url: String, driver: String) {
        Database.connect(url, driver)
    }

    override fun createScheme(tableName: String, table: Table) {
        tableMapList[tableName] = table
        transaction {
            SchemaUtils.create(table)
        }
    }

    override fun insertData(tableName: String, schemeName: String, data: Any) {
        val table = tableMapList[tableName]
        if (table != null) {
            transaction {
                table.insert {
                    table[] = data
                }
            }
        }
    }

    override fun selectData(tableName: String) {
        transaction {

        }
    }

    override fun updateData(tableName: String) {
        transaction {

        }
    }

    override fun deleteData(tableName: String) {
        transaction {

        }
    }

    override fun disConnection() {
        transaction {

        }
    }
}
