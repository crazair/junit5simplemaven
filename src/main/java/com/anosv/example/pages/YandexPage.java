package com.anosv.example.pages;

import com.anosv.example.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.*;

public class YandexPage extends BasePage{

	@FindBy(xpath = "//button[. = 'Найти']")
	private Button buttonSearch;

	@FindBy(xpath = "//input[@id='text']")
	private TextInput requestInput;

	@FindBy(xpath = "//div[@class='content__left']")
	private HtmlElement leftDiv;


	public YandexPage(WebDriver driver) {
		super(driver);
	}

	public void search(String text){
		requestInput.sendKeys(text);
		buttonSearch.click();
	}

	public String getLeftDivText(){
		WebDriverWait wait = new WebDriverWait(driver, WAIT_CONST);
		wait.until(ExpectedConditions.visibilityOf(leftDiv));
		return leftDiv.getText();
	}

	@Override
	protected void waitPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_CONST);
		wait.until(ExpectedConditions.visibilityOf(buttonSearch));
	}

}
