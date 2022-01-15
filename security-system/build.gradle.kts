dependencies {
    api(project(":common"))
    testFixtures(project(":common"))

    testApi(platform(Testing.Junit.bom))
    testApi(Testing.junit.jupiter.api)
    testApi(Testing.junit.jupiter.engine)

    testApi(Http4k.testing.hamkrest)
    testApi(Http4k.testing.chaos)
    testApi(Http4k.testing.approval)
    testApi(Http4k.testing.webdriver)

    testApi(project(":user-directory"))
    testApi(project(":entry-logger"))
    testApi(project(":sso"))
}

application {
    mainClass.set("verysecuresystems.SecuritySystemServerKt")
}