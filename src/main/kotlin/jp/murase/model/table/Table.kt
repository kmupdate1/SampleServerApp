package jp.murase.model.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

const val USER_TABLE           = "user_table"
const val LOGIN_ID = "login_id"
const val PASSWORD = "password"


const val CUSTOMER_BASIC_TABLE = "customer_basic_table"
const val CUSTOMER_ID   = "customer_id"
const val CUSTOMER_NAME ="customer_name"
const val CUSTOMER_AGE  ="customer_age"

const val CUSTOMER_INFO        = "customer_info"
const val CUSTOMER_PHONE = "customer_name"
const val CUSTOMER_EMAIL = "customer_age"

const val CUSTOMER_ORDER       = "customer_order"
const val ORDER_ID      = "order_id"
const val ORDER_DATE    = "order_date"

const val CUSTOMER_ADDRESS     = "customer_address"
const val ZIPCODE        = "zipcode"
const val MAIN_ADDRESS   = "main_address"
const val STREET_ADDRESS = "street_address"
const val OTHER          = "other"

const val PRODUCT              = "product"
const val PRODUCT_ID    = "product_id"
const val PRODUCT_NAME  = "product_name"
const val PRODUCT_PRICE = "product_price"

object UserTable: IntIdTable() {
    val loginId:  Column<String> = varchar(LOGIN_ID, 255)
    val password: Column<String> = varchar(PASSWORD, 255)
}

object CustomerBasicTable: Table() {
    val customerId:   Column<Int>    = integer(CUSTOMER_ID).autoIncrement()
    val customerName: Column<String> = varchar(CUSTOMER_NAME, 255)
    val customerAge:  Column<Int>    = integer(CUSTOMER_AGE)

    override val primaryKey = PrimaryKey(customerId)
}

object CustomerInfoTable: IntIdTable() {
    val customerName:  Column<String> = varchar(CUSTOMER_NAME, 255)
    val customerPhone: Column<String> = varchar(CUSTOMER_PHONE, 255)
    val customerEmail: Column<String> = varchar(CUSTOMER_EMAIL, 255)
}

object CustomerOrderTable: Table() {
    val orderId:    Column<Int>    = integer(ORDER_ID).autoIncrement()
    val customerId: Column<String> = varchar(CUSTOMER_ID, 255)
    val orderDate:  Column<String> = varchar(ORDER_DATE, 255)

    override val primaryKey = PrimaryKey(orderId)
}

object CustomerAddressTable: Table() {
    val customerId:    Column<Int>    = integer(CUSTOMER_ID).autoIncrement()
    val zipcode:       Column<String> = varchar(ZIPCODE, 255)
    val mainAddress:   Column<String> = varchar(MAIN_ADDRESS, 255)
    val streetAddress: Column<String> = varchar(STREET_ADDRESS, 255)
    val other:         Column<String> = varchar(OTHER, 255)

    override val primaryKey = PrimaryKey(customerId)
}

object ProductTable: Table() {
    val productId:     Column<Int>    = integer(PRODUCT_ID).autoIncrement()
    val productName:   Column<String> = varchar(PRODUCT_NAME, 255)
    val productPrice:  Column<Int>    = integer(PRODUCT_PRICE)

    override val primaryKey = PrimaryKey(productId)
}
