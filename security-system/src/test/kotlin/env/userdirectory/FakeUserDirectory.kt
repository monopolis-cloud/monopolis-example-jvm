package env.userdirectory

import org.http4k.chaos.ChaosEngine
import org.http4k.chaos.withChaosApi
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import verysecuresystems.Id
import verysecuresystems.User
import verysecuresystems.UserDirectory
import java.util.Random

class FakeUserDirectory(idGen: () -> Int = Random()::nextInt) : HttpHandler {

    private val engine = ChaosEngine()

    private val users = mutableMapOf<Id, User>()

    fun contains(newUser: User) = users.put(newUser.id, newUser)

    private val app = UserDirectory(idGen, users).withChaosApi(engine)

    override fun invoke(p1: Request) = app(p1)
}