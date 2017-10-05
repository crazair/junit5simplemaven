package com.anosv.example.Lifecycle;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleInterface {

    @BeforeAll
    default void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        System.out.println("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        System.out.println(String.format("About to execute [%s]",
                testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        System.out.println(String.format("Finished executing [%s]",
                testInfo.getDisplayName()));
    }
}
