package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.FileUploadPage;
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

public class PostCreationTest {

    private WebDriver driver;

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testPostCreation(BrowsersList browser) {

        MainPage mainPage;
        LoginPage loginPage;
        FileUploadPage uploadPage;

        // log in

        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        loginPage.login();

        // go to post creation
        mainPage.goToUpload();
        uploadPage = new FileUploadPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        uploadPage.uploadImage();



    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
