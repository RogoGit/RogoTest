package com.example.SoftwareTestingLab3.test_plans;

import com.example.SoftwareTestingLab3.page_objects.LoginPage;
import com.example.SoftwareTestingLab3.page_objects.MainPage;
import com.example.SoftwareTestingLab3.web_helpers.BrowsersList;
import com.example.SoftwareTestingLab3.web_helpers.DriverManager;
import com.example.SoftwareTestingLab3.web_helpers.URLConstants;
import com.example.SoftwareTestingLab3.web_helpers.UserCredentials;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;

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
        driver.get(URLConstants.LOG_IN_URL);
        loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertEquals("Не удалось войти в систему по указанному имени пользователя",
                UserCredentials.username, mainPage.getCurrentUserName());
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
