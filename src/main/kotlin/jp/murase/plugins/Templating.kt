package jp.murase.plugins

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.mustache.Mustache
import io.ktor.mustache.MustacheContent
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

const val PAGE_TITLE             = "Customer Manager"
const val TITLE                  = "株式会社綿重商店　顧客管理サービス"
const val MESSAGE_LABEL          = "ログイン"
const val MESSAGE_SIGN_IN        = "サインイン"
const val MESSAGE_VERIFY_INFO    = "ログイン情報の確認"
const val MESSAGE_REGISTER_INFO  = "ログイン情報を登録しました"
const val LOGIN_LABEL            = "ログインID"
const val PASSWORD_LABEL         = "パスワード"
const val SUBMIT_LOGIN_BUTTON    = "いくぞ！"
const val RESULT_LOGIN_LABEL     = "ログインIDまたはパスワードが違います"
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
                "message_label" to MESSAGE_LABEL,
                "login_id_label" to LOGIN_LABEL,
                "login_id" to "",
                "password_label" to PASSWORD_LABEL,
                "password" to "",
                "submit_login" to SUBMIT_LOGIN_BUTTON,
                "submit_sign_in" to SUBMIT_SIGN_ING_BUTTON,
                "flag_message_label" to false
            )
            call.respond(MustacheContent(TEMPLATE_FILE_NAME, model))
        }

        post("/") {
            val params: Parameters = call.receiveParameters()
            val model = mapOf(
                "page_title" to PAGE_TITLE,
                "title" to TITLE,
                "message_label" to MESSAGE_LABEL,
                "result_login" to RESULT_LOGIN_LABEL,
                "login_id_label" to LOGIN_LABEL,
                "login_id" to "${params["login_id"]}",
                "password_label" to PASSWORD_LABEL,
                "password" to "",
                "submit_login" to SUBMIT_LOGIN_BUTTON,
                "submit_sign_in" to SUBMIT_SIGN_ING_BUTTON,
                "result_login" to RESULT_LOGIN_LABEL,
                "flag_message_label" to false
            )
            call.respond(MustacheContent(TEMPLATE_FILE_NAME, model))
        }

        get("/sample") {

        }
    }
}
data class User(val loginId: String, val password: String)
