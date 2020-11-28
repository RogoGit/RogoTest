package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.*;
import com.example.SoftwareTestingLab3.web_helpers.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PostCreationTest {

    private WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    FileUploadPage uploadPage;
    PostCreationPage postCreationPage;
    UserPostsPage userPostsPage;

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testPostCreation(BrowsersList browser) {

        // log in

        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        loginPage.login();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // go to post image uploading
        mainPage.goToUpload();
        uploadPage = new FileUploadPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        uploadPage.uploadImage();

        //create post
        String postTitle = Util.createRandomSequence(20);
        String postDescription = Util.createRandomSequence(20);

        postCreationPage = new PostCreationPage(driver);
        postCreationPage.addPostTitle(js, postTitle);
        postCreationPage.addImageDescription(js, postDescription);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        postCreationPage.showUserMenu();
        postCreationPage.gotoPostsPage(js);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        userPostsPage = new UserPostsPage(driver);
        userPostsPage.gotoAll();
        wait.until(ExpectedConditions.visibilityOf(userPostsPage.firstPost));
        Assert.assertTrue("post did not appear", driver.getPageSource().contains(postTitle));

        //postCreationPage.clickAddTag();
        //wait.until(ExpectedConditions.visibilityOf(postCreationPage.tagActive));
        //postCreationPage.addTag(js, URLConstants.tagForPosts);
        //wait.until(ExpectedConditions.elementToBeClickable(postCreationPage.toCommunityButton));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        /*try {
            Thread.sleep(2300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();

        postCreationPage.makePostPublic(js);
        wait.until(ExpectedConditions.visibilityOf(postCreationPage.confirmPublic));
        if (browser.equals(BrowsersList.CHROME)) {
            js.executeScript("arguments[0].scrollIntoView(true);", postCreationPage.confirmPublic);
        }
        postCreationPage.confirmPublic(js);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

         check post
        postPage = new GalleryItemPage(driver);
        Assert.assertEquals("Post title is wrong", postPage.postTitle.getText(), postTitle);
        Assert.assertEquals("Post description is wrong", postPage.postDescription.getText(), postDescription); */

    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void deletePost(BrowsersList browser) {

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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //


    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
