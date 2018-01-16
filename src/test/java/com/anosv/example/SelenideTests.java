package com.anosv.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideTests {

    static {
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "test-result/reports";

        //Configuration.FileDownloadMode;
    }


    @Test
    void testSelenideSimple(){
        open("https://yandex.ru/");
        $(byId("text")).setValue("какой-то текст!!!!!!!");
        $(byXpath(".//div[@class='search2__button']/button")).click();
        //screenshot("test.");
       // $(By.className("search2__button")).click();
        try{Thread.sleep(3500);}catch (Exception e){};
    }

}
