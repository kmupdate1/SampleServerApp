package jp.murase.model

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

const val POSTGRESQL = "PostgresSQL"

class PostgresSQL: MetaDatabase {
    private val tableMapList: ArrayList<MutableMap<String,Table>> = arrayListOf()

    override fun establish(url: String, driver: String) {
        Database.connect(url, driver)
    }

    override fun createScheme(tableName: String, table: Table) {
        tableMapList.add(mutableMapOf(tableName to table))
        transaction {

        }
    }

    override fun insertData(tableName: String, data: Any) {
        transaction {

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
