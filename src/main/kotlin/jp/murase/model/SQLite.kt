package jp.murase.model

import org.jetbrains.exposed.sql.*
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

    override fun insertData(tableName: String, column: Column<Int>, data: Int) {
        val table: Table? = tableMapList[tableName]
        if (table != null) {
            transaction {
                table.insert {
                    it[column] = data
                }
            }
        }
    }

    override fun insertData(tableName: String, column: Column<String>, data: String) {
        val table: Table? = tableMapList[tableName]
        if (table != null) {
            println("table : $table, column : $column, data : $data")
            transaction {
                table.insert {
                    it[column] = data
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
