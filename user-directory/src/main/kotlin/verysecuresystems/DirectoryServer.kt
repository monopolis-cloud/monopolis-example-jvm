package verysecuresystems

import org.http4k.cloudnative.env.Environment
import org.http4k.cloudnative.env.EnvironmentKey
import org.http4k.lens.int
import org.http4k.server.Undertow
import org.http4k.server.asServer
import verysecuresystems.UserDirectorySettings.PORT

fun UserDirectoryServer(env: Environment) = UserDirectory().asServer(Undertow(PORT(env)))

object UserDirectorySettings {
    val PORT = EnvironmentKey.int().required("PORT")
}

fun main() {
    UserDirectoryServer(Environment.ENV).start()
}