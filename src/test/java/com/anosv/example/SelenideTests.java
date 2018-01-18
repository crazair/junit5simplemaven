package com.anosv.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


@Feature("My Feature")
public class SelenideTests {

    static {
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "test-result/reports";
    }

    @Test
    @TmsLink("1234")
    void testSelenideSimple(){
        open("https://yandex.ru/");
        firstStep("123123123");
        firstStep2("dsafasdf");
        $(byId("text")).setValue("какой-то текст!!!!!!!");
        $(byXpath(".//div[@class='search2__button']/button")).click();
        try{Thread.sleep(1000);}catch (Exception e){};
    }

    @Test
    @Issue("MYISSUE-1")
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    @Link("ALM...")
    @TmsLinks({@TmsLink("1"), @TmsLink("2")})
    void testSelenideSimple2(){
        open("https://yandex.ru/");
        $(byId("text")).setValue("какой-то текст!!!!!!!");
        $(byXpath(".//div[@class='search2__button234']/button")).click();
        try{Thread.sleep(1000);}catch (Exception e){};
    }

    @Step("Open {0} page.")
    public void firstStep(String xxx) {
    }

    @Step("Open {0} page.")
    public void firstStep2(String yyy) {
    }

}
