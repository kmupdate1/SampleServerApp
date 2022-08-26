package jp.murase.control

import jp.murase.model.MetaDatabase
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class DBController(
    private val database: MetaDatabase
    ): DBConnectable {

    override fun establish(url: String, driver: String): DBController {
        database.establish(url, driver)
        return this
    }

    override fun createSchema(tableName: String, table: Table): DBController {
        database.createScheme(tableName, table)
        return this
    }

    override fun insertData(tableName: String, column: Column<Int>, data: Int): DBController {
        database.insertData(tableName, column, data)
        return this
    }

    override fun insertData(tableName: String, column: Column<String>, data: String): DBController {
        database.insertData(tableName, column, data)
        return this
    }

    override fun selectData(tableName: String): DBController {

        return this
    }

    override fun updateData(tableName: String): DBController {

        return this
    }

    override fun deleteData(tableName: String): DBController {

        return this
    }

    override fun disConnection(): Boolean {
        var result = false

        return result
    }


}
