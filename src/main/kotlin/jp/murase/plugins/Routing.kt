package jp.murase.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    

    routing {
        get("/example") {
            call.respondText("This is example page.")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static/contents/")
        }
    }
}
