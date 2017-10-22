package com.anosv.example.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }

}
