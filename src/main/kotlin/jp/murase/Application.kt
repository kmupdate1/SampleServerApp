package jp.murase

import io.ktor.application.*
import jp.murase.manager.DRIVER
import jp.murase.manager.URL
import jp.murase.manager.databaseManagement
import jp.murase.model.table.UserTable
import jp.murase.plugins.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureTemplating()
    configureRouting()

    //databaseManagement()

/*    Database.connect(URL, DRIVER)
    transaction {
        UserTable.insert {
            it[loginId]  = "m_s620@icloud.com"
            it[password] = "naka23"
        }
    }
*/
}
