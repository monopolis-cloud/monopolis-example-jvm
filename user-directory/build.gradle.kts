dependencies {
    api(project(":common"))

    testApi(platform(Testing.Junit.bom))
    testApi(Testing.junit.jupiter.api)
    testApi(Testing.junit.jupiter.engine)
}

application {
    mainClass.set("verysecuresystems.SSOServerKt")
}