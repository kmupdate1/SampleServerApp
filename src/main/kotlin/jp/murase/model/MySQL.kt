package jp.murase.model

import jp.murase.model.table.UserTable.loginId
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

const val MYSQL = "MySQL"

class MySQL: MetaDatabase {
    private val tableMap: MutableMap<String,Table> = mutableMapOf()

    override fun establish(url: String, driver: String) {
        Database.connect(url, driver)
    }

    override fun createScheme(tableName: String, table: Table) {
        tableMap[tableName] = table
        transaction {
            table
        }
    }

    override fun insertData(tableName: String, data: Any) {
        val table = tableMap[tableName]
        if ( table != null ) {
            transaction {
/*
                table.insert {
                    it[loginId] = data
                }
*/
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
