# Cucumber lifecycle demo

This repo contains the examples for the [blog article about Getting @BeforeAll and @AfterAll behaviour with Cucumber JVM and JUnit](https://metamorphant.de/blog/2020-03-10-beforeall-afterall-cucumber-jvm-junit/). It contains a little set of demos showing how you can tap into the lifecycle of JVM cucumber to create the equivalent of a `@BeforeAll`/`@AfterAll`.

## How to reproduce

### Cucumber EventListener

```console
cd cucumber-eventlistener-demo
mvn test
```

Please note the order of output: The lifecycle hooks' output is interleaved with the other Cucumber test output.

### JUnit Wrapper

```console
cd junit-wrapper-demo
mvn test
```

Please note the order of output: The `@BeforeClass`/`@AfterClass` hooks' output is written before/after the whole Cucumber test and runner output. The `@Before`/`@After` hooks are never executed.

### Maven Failsafe

Maven failsafe is bound to the `integration-test` phase resp. the `verify` phase instead of the `test` phase of the [Maven build lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

```console
cd maven-failsafe-demo
mvn verify
```

In the output you notice the additional echo of the port in the `pre-integration-test` phase. In this case, the port mappings are managed by maven and injected into the test as system properties from the outside.

This gives you less detailed control, but draws a clear boundary. Also, it enables you to run the test in the same fashion against different environments without having to change the code.
