package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.LoginPage;
import com.example.SoftwareTestingLab3.page_objects.MainPage;
import com.example.SoftwareTestingLab3.web_helpers.BrowsersList;
import com.example.SoftwareTestingLab3.web_helpers.DriverManager;
import com.example.SoftwareTestingLab3.web_helpers.UserCredentials;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testUserRegistration(BrowsersList browser) {

        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        //driver.get(URLConstants.LOG_IN_URL);
        loginPage = new LoginPage(driver);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        loginPage.login();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(mainPage.currentUserName));

        Assert.assertEquals("Failed to login with given credentials",
                UserCredentials.username, mainPage.getCurrentUserName());
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
