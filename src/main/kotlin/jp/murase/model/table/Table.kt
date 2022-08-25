package jp.murase.model.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

const val USER_TABLE           = "user_table"

const val CUSTOMER_BASIC_TABLE = "customer_basic_table"
const val CUSTOMER_INFO        = "customer_info"
const val CUSTOMER_ORDER       = "customer_order"
const val CUSTOMER_ADDRESS     = "customer_address"

const val PRODUCT              = "product"

object UserTable: IntIdTable() {
    val loginId:  Column<String> = varchar("login_id", 255)
    val password: Column<String> = varchar("password", 255)
}

object CustomerBasicTable: Table() {
    val customerId:   Column<Int>    = integer("customer_id").autoIncrement()
    val customerName: Column<String> = varchar("customer_name", 255)
    val customerAge:  Column<Int>    = integer("customer_age")

    override val primaryKey = PrimaryKey(customerId)
}

object CustomerInfoTable: IntIdTable() {
    val customerName:  Column<String> = varchar("customer_name", 255)
    val customerPhone: Column<String> = varchar("customer_name", 255)
    val customerEmail: Column<String> = varchar("customer_name", 255)
}

object CustomerOrderTable: Table() {
    val orderId:    Column<Int>    = integer("order_id").autoIncrement()
    val customerId: Column<String> = varchar("customer_id", 255)
    val orderDate:  Column<String> = varchar("order_date", 255)

    override val primaryKey = PrimaryKey(orderId)
}

object CustomerAddressTable: Table() {
    val customerId:    Column<Int>    = integer("customer_id").autoIncrement()
    val zipcode:       Column<String> = varchar("zipcode", 255)
    val mainAddress:   Column<String> = varchar("main_address", 255)
    val streetAddress: Column<String> = varchar("street_address", 255)
    val other:         Column<String> = varchar("other", 255)

    override val primaryKey = PrimaryKey(customerId)
}

object ProductTable: Table() {
    val productId:     Column<Int>    = integer("product_id").autoIncrement()
    val productName:   Column<String> = varchar("product_name", 255)
    val productPricce: Column<Int>    = integer("product_price")

    override val primaryKey = PrimaryKey(productId)
}
