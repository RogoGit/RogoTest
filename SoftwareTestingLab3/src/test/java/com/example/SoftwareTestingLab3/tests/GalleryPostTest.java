package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.GalleryItemPage;
import com.example.SoftwareTestingLab3.page_objects.LoginPage;
import com.example.SoftwareTestingLab3.page_objects.MainPage;
import com.example.SoftwareTestingLab3.web_helpers.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GalleryPostTest {

    private WebDriver driver;
    private GalleryItemPage galleryItemPage;

    private void setUpEnvironment(BrowsersList browser) {

        MainPage mainPage;
        LoginPage loginPage;

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

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testCommentUpDownVoting(BrowsersList browser) {

        setUpEnvironment(browser);

        driver.get(URLConstants.ANOTHER_USER_TEST_POST);
        galleryItemPage = new GalleryItemPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", galleryItemPage.postImage);

        //downvote comment
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Integer initialPointsPreDown = galleryItemPage.getTotalCommentPoints();
        galleryItemPage.downVoteComment();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("comment points after downvote is wrong", (initialPointsPreDown - 1), (int) galleryItemPage.getTotalCommentPoints());

        //undo downvote
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialPointsPreUndoDown = galleryItemPage.getTotalCommentPoints();
        galleryItemPage.downVoteComment();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("comment points after undo downvote is wrong", (initialPointsPreUndoDown + 1), (int) galleryItemPage.getTotalCommentPoints());

        //upvote comment
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialPointsPreUp = galleryItemPage.getTotalCommentPoints();
        galleryItemPage.upVoteComment();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("comment points after upvote is wrong", (initialPointsPreUp + 1), (int) galleryItemPage.getTotalCommentPoints());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Integer initialPointsPreUndoUp = galleryItemPage.getTotalCommentPoints();
        galleryItemPage.upVoteComment();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("comment points after undo upvote is wrong", (initialPointsPreUndoUp - 1), (int) galleryItemPage.getTotalCommentPoints());

    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testCommentPosting(BrowsersList browser) {

        setUpEnvironment(browser);

        driver.get(URLConstants.TEST_POST_URL);
        galleryItemPage = new GalleryItemPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", galleryItemPage.postImage);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.commentWriteSection));

        String commentBody = Util.createRandomSequence(20);
        galleryItemPage.commentWriteSection.sendKeys(commentBody);
        js.executeScript("arguments[0].click();", galleryItemPage.postCommentButton);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("comment author is wrong", UserCredentials.username, galleryItemPage.commentByAuthor.getText());
        Assert.assertEquals("comment body is wrong", commentBody, galleryItemPage.commentBody.getText());

    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testCommentDeleting(BrowsersList browser) {

        setUpEnvironment(browser);

        driver.get(URLConstants.TEST_POST_URL);
        galleryItemPage = new GalleryItemPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", galleryItemPage.postImage);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.commentsListSection));

        Actions actions = new Actions(driver);
        actions.moveToElement(galleryItemPage.commentByAuthor).perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        String commentBody = galleryItemPage.commentBody.getText();

        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.commentDropdown));
        galleryItemPage.showCommentActionsMenu();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.commentDeleteButton));
        galleryItemPage.deleteComment(js);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertFalse("comment did not disappear", driver.getPageSource().contains(commentBody));

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
