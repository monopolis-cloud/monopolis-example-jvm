package verysecuresystems

import org.http4k.cloudnative.env.Environment
import org.http4k.cloudnative.env.EnvironmentKey
import org.http4k.lens.int
import org.http4k.server.Undertow
import org.http4k.server.asServer
import verysecuresystems.EntryLoggerSettings.PORT

fun EntryLoggerServer(env: Environment) = EntryLogger().asServer(Undertow(PORT(env)))

object EntryLoggerSettings {
    val PORT = EnvironmentKey.int().required("PORT")
}

fun main() {
    EntryLoggerServer(Environment.ENV).start()
}