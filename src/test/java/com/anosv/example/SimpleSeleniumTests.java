package com.anosv.example;

import com.anosv.example.base.BaseSeleniumTest;

import org.junit.jupiter.api.*;


public class SimpleSeleniumTests extends BaseSeleniumTest {

    //private static HomePage homepage = new HomePage(driver);

    @Test
    @DisplayName("Пример теста с использованием selenium! 😎")
    void testHomePageHasAHeader(TestInfo testInfo){
        LOG.info("Start test: " + testInfo.getDisplayName());
        driver.get(baseUrl);
       // Assertions.assertFalse("".equals(homepage.getH1()));

        //try{Thread.sleep(5000);}catch (Exception e){}
    }

}
