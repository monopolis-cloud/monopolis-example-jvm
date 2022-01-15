package verysecuresystems

import org.http4k.cloudnative.env.Environment
import org.http4k.cloudnative.env.Environment.Companion.ENV
import org.http4k.cloudnative.env.EnvironmentKey
import org.http4k.core.with
import org.http4k.filter.debug
import org.http4k.lens.int
import org.http4k.server.Undertow
import org.http4k.server.asServer
import verysecuresystems.UserDirectorySettings.PORT

fun UserDirectoryServer(env: Environment) = UserDirectory().debug().asServer(Undertow(PORT(env)))

object UserDirectorySettings {
    val PORT = EnvironmentKey.int().required("PORT")
}

fun main(args: Array<String>) {
    UserDirectoryServer(ENV.with(PORT of args.port)).start()
}
