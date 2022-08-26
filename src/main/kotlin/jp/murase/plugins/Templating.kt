package jp.murase.plugins

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.mustache.Mustache
import io.ktor.mustache.MustacheContent
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import jp.murase.manager.URL
import jp.murase.manager.DRIVER
import jp.murase.model.table.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

const val PAGE_TITLE             = "Customer Manager"
const val TITLE                  = "株式会社綿重商店　顧客管理サービス"
const val MESSAGE_LOGIN_LABEL    = "ログイン"
const val MESSAGE_SIGN_IN_LABEL  = "サインイン"
const val MESSAGE_VERIFY_INFO    = "ログイン情報の確認"
const val MESSAGE_REGISTER_INFO  = "ログイン情報を登録しました"
const val LOGIN_LABEL            = "ログインID："
const val PASSWORD_LABEL         = "パスワード："
const val SUBMIT_LOGIN_BUTTON    = "ログイン"
const val RESULT_LOGIN_LABEL     = "ログインIDまたはパスワードが違います"
const val RESULT_NO_ID           = "ログインIDが存在しません<br>サインインをしてください"
const val RESULT_SIGN_IN_LABEL   = "パスワードが一致しません"
const val SUBMIT_SIGN_ING_BUTTON = "サインイン"

const val TEMPLATE_FILE_NAME = "form_user_info.hbs"

fun Application.configureTemplating() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }

    routing {
        get("/") {
            val model = mapOf(
                "page_title" to PAGE_TITLE,
                "title" to TITLE,
                "message_label" to MESSAGE_LOGIN_LABEL,
                "login_id_label" to LOGIN_LABEL,
                "login_id" to "",
                "password_label" to PASSWORD_LABEL,
                "password" to "",
                "submit_login" to SUBMIT_LOGIN_BUTTON,
                "submit_sign_in" to SUBMIT_SIGN_ING_BUTTON
            )
            call.respond(MustacheContent(TEMPLATE_FILE_NAME, model))
        }

        post("/") {
            val params: Parameters = call.receiveParameters()
            val model = mapOf(
                "page_title" to PAGE_TITLE,
                "title" to TITLE,
                "message_label" to MESSAGE_LOGIN_LABEL,
                "result_login" to RESULT_LOGIN_LABEL,
                "login_id_label" to LOGIN_LABEL,
                "login_id" to "${params["login_id"]}",
                "password_label" to PASSWORD_LABEL,
                "password" to "",
                "submit_login" to SUBMIT_LOGIN_BUTTON,
                "submit_sign_in" to SUBMIT_SIGN_ING_BUTTON,
                "result_login" to RESULT_NO_ID
            )
            call.respond(MustacheContent(TEMPLATE_FILE_NAME, model))
        }

        get("/sign-in") {
            val model = mapOf(
                "page_title" to PAGE_TITLE,
                "title" to TITLE,
                "message_label" to MESSAGE_LOGIN_LABEL,
                "login_id_label" to LOGIN_LABEL,
                "login_id" to "",
                "password_label" to PASSWORD_LABEL,
                "password" to "",
                "submit_login" to SUBMIT_LOGIN_BUTTON,
                "result_sign_in_label" to RESULT_SIGN_IN_LABEL,
                "flag_password_form" to true,
                "frag_appear_hr_tag" to false,
                "frag_sign_in_button" to false
            )
            call.respond(MustacheContent(TEMPLATE_FILE_NAME, model))
        }

        get("/sample") {
            Database.connect(URL, DRIVER)
            var res = ""
            transaction {
                UserTable.selectAll().forEach {
                    res += """
                        <li class="list-group-item">
                        ログインID : ${it[UserTable.loginId]}
                        <br>
                        パスワード : ${it[UserTable.password]}
                        </li>
                    """.trimIndent()
                }
            }

            val model = mapOf(
                "title" to "Sample page",
                "message" to "This is sample page.",
                "data" to res
            )
            call.respond(MustacheContent("sample.hbs", model))
        }
    }
}
data class User(val loginId: String, val password: String)
