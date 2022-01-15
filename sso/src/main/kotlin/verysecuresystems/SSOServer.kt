package verysecuresystems

import org.http4k.cloudnative.env.Environment
import org.http4k.cloudnative.env.EnvironmentKey
import org.http4k.core.Credentials
import org.http4k.core.Uri
import org.http4k.core.extend
import org.http4k.core.with
import org.http4k.lens.int
import org.http4k.lens.uri
import org.http4k.server.Undertow
import org.http4k.server.asServer
import verysecuresystems.SSOSettings.PORT
import verysecuresystems.SSOSettings.SECURITY_SERVER_URL

fun SSOServer(env: Environment) = SSO(
    Credentials("user", "password"),
    OAuthClientData(
        Credentials("securityServer", "securityServerSecret"),
        SECURITY_SERVER_URL(env).extend(Uri.of("/openapi/oauth2-redirect.html"))
    ),
    OAuthClientData(
        Credentials("securityServer", "securityServerSecret"),
        SECURITY_SERVER_URL(env).extend(
            Uri.of("/api/oauth/callback")
        )
    )
).asServer(Undertow(PORT(env)))

object SSOSettings {
    val PORT = EnvironmentKey.int().required("PORT")
    val SECURITY_SERVER_URL = EnvironmentKey.uri().required("SECURITY_SERVER_URL")
}

fun main(args: Array<String>) {
    SSOServer(Environment.ENV.with(PORT of args.port)).start()
}
