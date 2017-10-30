package com.anosv.example.Lifecycle;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifecycleInterface {

    Logger LOGGER = Logger.getRootLogger();

    @BeforeAll
    default void beforeAllTests() {
        LOGGER.info("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        LOGGER.info("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOGGER.info(String.format("About to execute [%s]",
                testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOGGER.info(String.format("Finished executing [%s]",
                testInfo.getDisplayName()));
    }
}
