package jp.murase.manager

import jp.murase.control.DBController
import jp.murase.model.SQLite
import jp.murase.model.table.*

const val URL    = "jdbc:sqlite:/Users/ken/data/wataju/customer_manage_system.db"
const val DRIVER = "org.sqlite.JDBC"

fun databaseManagement() {

    DBController(SQLite())
        .establish(URL, DRIVER)
        .createSchema(USER_TABLE, UserTable)
        .insertData(USER_TABLE, UserTable.loginId, "lax.potcx1562@gmail.com")
        .insertData(USER_TABLE, UserTable.password, "smiley")
        .insertData(USER_TABLE, UserTable.loginId, "m_s620@icloud.com")
        .insertData(USER_TABLE, UserTable.password, "naka23")
        .insertData(USER_TABLE, UserTable.loginId, "jtjm777@yahoo.co.jp")
        .insertData(USER_TABLE, UserTable.password, "takoyaki")
        .createSchema(PRODUCT_TABLE, ProductTable)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 45)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "芳醇美濃路本醸造醤油 1.0L")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 475)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 23)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 756)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 11)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 626)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 20)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 712)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 28)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 1134)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 73)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 540)
        .insertData(PRODUCT_TABLE, ProductTable.productId, 89)
        .insertData(PRODUCT_TABLE, ProductTable.productName, "")
        .insertData(PRODUCT_TABLE, ProductTable.productPrice, 626)

}
