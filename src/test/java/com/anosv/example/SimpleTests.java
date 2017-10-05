package com.anosv.example;

import static java.time.Duration.ofMillis;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.Matchers.endsWith;

import com.anosv.example.Lifecycle.TestLifecycleInterface;
import org.junit.jupiter.api.*;

@DisplayName("Набор простых тестов на JUnit 5! 😎😎😎")
public class SimpleTests implements TestLifecycleInterface {

    @BeforeAll //Метод, который выполяется перед тестовым набором (классом)
    static void initAll() {
    }

    @BeforeEach
        //Метод, который выполяется перед каждым тестом
    void init() {
    }

    @Test
    @DisplayName("Мой первый тест проверяющий сложение! 😎")
    void myFirstTest(TestInfo testInfo) {           //методы пишутся без public!
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("Мой первый тест проверяющий сложение! 😎", testInfo.getDisplayName(),
                () -> "TestInfo is injected correctly");
    }

    @Test
    @Tag("jenkins")
    @DisplayName("Тест для запуска по тегам...")
        //@RepeatedTest(5)            //Данный тест нужно запустить 5 раз! При этом, каждый такой вызов будет независимым тестом, а значит для него будут работать аннотации @BeforeAll, @BeforeEach, @AfterEach и @AfterAll.
    void jenkinsOnly() {
        fail("fail");
    }

    @Test
    @DisplayName("Тест с примерами различных ассершинов...")
    public void assertions() {
        assertEquals("Java", new TestEntity().getLanguage());

        assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");

        assertTrue(() -> "".isEmpty(), "string should be empty");

        assertAll(
                () -> assertEquals("John", new TestEntity().getFirstName()),
                () -> assertEquals("Doe", new TestEntity().getLastName())
        );

        // в группе все ассерты исполняются независимо, успех - когда прошли успешно все ассерты
        assertAll("Несколько проверок стрингового значения...",
                () -> assertThat("https://habrahabr.ru", startsWith("https")),
                () -> assertThat("https://habrahabr.ru", endsWith(".ru"))
        );

        assertIterableEquals(asList(1, 2, 3), asList(1, 2, 3));

        assertLinesMatch(
                asList("можно сравнивать строки", "а можно по regex: \\d{2}\\.\\d{2}\\.\\d{4}"),
                asList("можно сравнивать строки", "а можно по regex: 12.09.2017")
        );
    }

    @Test
    @DisplayName("Тест показывающий работу 'предположения' (assumptions)")
    public void assumptions() {
        assumeTrue(2 == 3);//Отключение теста только в зависимости от каких-то условий. В данном случае Bool значения.
        assertTrue(true);
    }

    @Test
    @DisplayName("Проверка длительности работы теста... assertTimeout")
    void timeoutExceeded() {
        assertTimeout(ofMillis(100), () -> Thread.sleep(100));
    }

    @Test
    @DisplayName("Проверка длительности работы теста... assertTimeoutPreemptively (не дожидаемся окончания работы теста)")
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofMillis(10), () -> Thread.sleep(100));
    }

    @Test
    @DisplayName("Тест проверяющий появление экспепшена как ожидаемого результата")
    void exception() {
        assertThrows(NullPointerException.class, () -> ((Object) null).toString());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
