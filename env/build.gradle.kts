dependencies {
    testApi(project(":entry-logger"))
    testApi(project(":security-system"))
    testApi(project(":sso"))
    testApi(project(":user-directory"))


    testApi(platform(Testing.Junit.bom))
    testApi(Testing.junit.jupiter.api)
    testApi(Testing.junit.jupiter.engine)
}
