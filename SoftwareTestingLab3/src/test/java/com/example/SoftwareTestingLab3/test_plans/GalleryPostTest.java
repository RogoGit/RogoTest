package com.example.SoftwareTestingLab3.test_plans;

import com.example.SoftwareTestingLab3.page_objects.GalleryItemPage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GalleryPostTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private GalleryItemPage galleryItemPage;


    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testUserPostUpDownVoting(BrowsersList browser) {

        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.login();

        mainPage.goToFirstVideoInGallery();
        galleryItemPage = new GalleryItemPage(driver);

        //downvote post
        Integer initialScore = galleryItemPage.getTotalPostScore();
        galleryItemPage.downVotePost();
        Assert.assertEquals("post score after downvote is wrong", (initialScore - 1), (int) galleryItemPage.getTotalPostScore());

        //upvote post
        Integer initialScoreNew = galleryItemPage.getTotalPostScore();
        galleryItemPage.upVotePost();
        Assert.assertEquals("post score after upvote is wrong", (initialScoreNew + 1), (int) galleryItemPage.getTotalPostScore());

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
