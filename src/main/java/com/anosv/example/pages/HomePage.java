package com.anosv.example.pages;

import com.anosv.example.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	private final String H1_TAG = "h1";
	
	@FindBy(how = How. TAG_NAME, using = H1_TAG)
	@CacheLookup
	private WebElement h1Element;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this.getClass());
	}
	
	public String getH1() {
		return h1Element.getText();
	}

}
