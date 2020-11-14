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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GalleryPostTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private GalleryItemPage galleryItemPage;

    private void setUpEnvironment(BrowsersList browser) {
        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testUserPostUpDownVoting(BrowsersList browser) {

        setUpEnvironment(browser);

        //mainPage.goToFirstVideoInGallery();
        //driver.get(URLConstants.TEST_POST_URL);
        driver.get(URLConstants.ANOTHER_USER_TEST_POST);
        galleryItemPage = new GalleryItemPage(driver);

        // I am sorry, but it seems to me that I it's the only solution
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //downvote post

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOf(galleryItemPage.gallerySlideBar));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialScorePreDown = galleryItemPage.getTotalPostScore();
        galleryItemPage.downVotePost();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
             Thread.sleep(1200);
        } catch (InterruptedException ex) {
             ex.printStackTrace();
        }
        Assert.assertEquals("post score after downvote is wrong", (initialScorePreDown - 1), (int) galleryItemPage.getTotalPostScore());

        //undo downvote
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialScorePreUndoDown = galleryItemPage.getTotalPostScore();
        galleryItemPage.downVotePost();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals("post score after undo downvote is wrong", (initialScorePreUndoDown + 1), (int) galleryItemPage.getTotalPostScore());

        //upvote post
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialScorePreUp = galleryItemPage.getTotalPostScore();
        galleryItemPage.upVotePost();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals("post score after upvote is wrong", (initialScorePreUp + 1), (int) galleryItemPage.getTotalPostScore());

        //undo upvote post
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialScorePreUndoUp = galleryItemPage.getTotalPostScore();
        galleryItemPage.upVotePost();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals("post score after undo upvote is wrong", (initialScorePreUndoUp - 1), (int) galleryItemPage.getTotalPostScore());

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
