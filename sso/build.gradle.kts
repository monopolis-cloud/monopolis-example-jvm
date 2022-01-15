dependencies {
    api(project(":common"))
    api(Http4k.core)
    api(Http4k.securityOauth)

    testApi(platform(Testing.Junit.bom))
    testApi(Testing.junit.jupiter.api)
    testApi(Testing.junit.jupiter.engine)
}
