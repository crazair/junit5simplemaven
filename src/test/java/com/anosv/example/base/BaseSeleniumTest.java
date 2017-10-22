package com.anosv.example.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSeleniumTest {
    protected static final Logger LOG = Logger.getRootLogger();

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    private static final String PROPERTIES_URL = "application.properties";

    private static Properties properties = new Properties();
    protected static String baseUrl;
    protected static WebDriver driver;

    static {
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer_x64_2.39.0.exe");
        //System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.v0.19.0-win64.exe");
    }


    @BeforeAll
    private static void init() {
        try {
            LOG.info("Start init in BaseSeleniumTest!");

            properties.load(new FileReader(PROPERTIES_URL));
            baseUrl = getProperty("base.url");

            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("initialBrowserUrl", "http://ya.ru");

            driver = new InternetExplorerDriver(capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOG.error("Exception BaseSeleniumTest init: ", e);
        }
    }

    @AfterAll
    private static void killWebDriver() {
        LOG.info("killWebDriver!!!");
        driver.close();
    }

    protected static String getProperty(String propertyKey) {
        LOG.info("BaseSeleniumTest getProperty: " + propertyKey + " Value: " + properties.getProperty(propertyKey));
        return properties.getProperty(propertyKey);
    }

}
