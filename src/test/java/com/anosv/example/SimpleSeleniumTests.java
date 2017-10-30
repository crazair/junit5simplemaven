package com.anosv.example;

import com.anosv.example.Lifecycle.TestLifecycleInterface;
import com.anosv.example.base.BaseSeleniumTest;

import com.anosv.example.pages.YandexPage;
import org.junit.jupiter.api.*;


public class SimpleSeleniumTests extends BaseSeleniumTest implements TestLifecycleInterface {

    private YandexPage yandexPage;

    @BeforeAll
    void initPages() {
        yandexPage = new YandexPage(driver);
    }

    @Test
    @DisplayName("Пример теста с использованием selenium! 😎")
    void testYandexTitleEndEmptySearch() {
        toBaseUrl();
        Assertions.assertEquals(driver.getTitle(), "Яндекс");
        yandexPage.search("");
        //try{Thread.sleep(5000);}catch (Exception e){}
        Assertions.assertTrue(yandexPage.getLeftDivText().contains("Задан пустой поисковый запрос"));
    }

}
