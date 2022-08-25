package jp.murase.manager

import jp.murase.control.DBController
import jp.murase.model.SQLite
import jp.murase.model.table.USER_TABLE
import jp.murase.model.table.UserTable

const val URL    = "jdbc:sqlite:/Users/ken/data/wataju/customer_manage_system.db"
const val DRIVER = "org.sqlite.JDBC"

fun databaseManagement() {

    DBController(SQLite())
        .establish(URL, DRIVER)
        .createSchema(USER_TABLE, UserTable)
        .insertData(USER_TABLE, "lax.potcx1562@gmail.com")
        .insertData(USER_TABLE, "smiley")
}
