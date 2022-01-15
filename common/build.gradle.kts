dependencies {
    api(platform(Http4k.bom))
    api(Http4k.core)
    api(Http4k.contract)
    api(Http4k.cloudnative)
    api(Http4k.format.jackson)
    api(Http4k.securityOauth)
    api(Http4k.server.undertow)
    api(Http4k.template.handlebars)

    testApi(platform(Testing.Junit.bom))
    testApi(Testing.junit.jupiter.api)
    testApi(Testing.junit.jupiter.engine)

    testApi(Http4k.testing.hamkrest)
    testApi(Http4k.testing.chaos)
    testApi(Http4k.testing.approval)
    testApi(Http4k.testing.webdriver)
}
