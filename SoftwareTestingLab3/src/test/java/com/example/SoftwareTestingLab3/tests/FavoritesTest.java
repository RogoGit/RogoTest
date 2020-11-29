package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.*;
import com.example.SoftwareTestingLab3.web_helpers.BrowsersList;
import com.example.SoftwareTestingLab3.web_helpers.DriverManager;
import com.example.SoftwareTestingLab3.web_helpers.URLConstants;
import com.example.SoftwareTestingLab3.web_helpers.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FavoritesTest {

    private WebDriver driver;
    private MainPage mainPage;
    private GalleryItemPage galleryItemPage;
    private UserPostsPage userPostsPage;

    private void setUpEnvironment(BrowsersList browser) {

        LoginPage loginPage;

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
    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void addToFavorites(BrowsersList browser) {

        // log in
        setUpEnvironment(browser);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // go to post
        if (browser.equals(BrowsersList.FIREFOX)) {
            mainPage.goToFirstVideoInGallery();
        } else {
            mainPage.goToSecondVideoInGallery();
        }

        galleryItemPage = new GalleryItemPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String postTitle = galleryItemPage.postTitle.getText();
        galleryItemPage.addToFavorites();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.chooseAllFavorites));
        galleryItemPage.chooseAllFavorites();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // go to favorites
        galleryItemPage.showUserMenu();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.toUserFavorites));
        galleryItemPage.gotoFavoritesPage();

        userPostsPage = new UserPostsPage(driver);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertTrue("post did not appear in favorites", driver.getPageSource().contains(postTitle));

    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void removeFromFavorites(BrowsersList browser) {

        // log in
        setUpEnvironment(browser);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        mainPage.showUserMenu();
        wait.until(ExpectedConditions.visibilityOf(mainPage.toUserFavorites));
        mainPage.gotoFavoritesPage();

        userPostsPage = new UserPostsPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://imgur.com/gallery/" + userPostsPage.getPostHref(userPostsPage.firstFavoritePost));

        galleryItemPage = new GalleryItemPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String postTitle = galleryItemPage.postTitle.getText();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        galleryItemPage.addToFavorites();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // go to favorites
        galleryItemPage.showUserMenu();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.toUserFavorites));
        galleryItemPage.gotoFavoritesPage();

        userPostsPage = new UserPostsPage(driver);
        //wait.until(ExpectedConditions.visibilityOf(userPostsPage.firstFavoritePost));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Assert.assertTrue("post did not disappear in favorites", driver.getPageSource().contains(postTitle));
    }

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void newFavoritesFolderTest(BrowsersList browser) {

        // log in
        setUpEnvironment(browser);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        mainPage.showUserMenu();
        wait.until(ExpectedConditions.visibilityOf(mainPage.toUserFavorites));
        mainPage.gotoFavoritesPage();

        userPostsPage = new UserPostsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(userPostsPage.createNewFolder));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        userPostsPage.addNewFolder();
        wait.until(ExpectedConditions.visibilityOf(userPostsPage.newFolderName));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        driver.get(URLConstants.BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // go to post
        js.executeScript("arguments[0].scrollIntoView(true);", mainPage.thirdVideoInGallery);
        if (browser.equals(BrowsersList.FIREFOX)) {
            mainPage.goToThirdVideoInGallery();
        } else {
            mainPage.goToFourthVideoInGallery();
        }

        galleryItemPage = new GalleryItemPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String postTitle = galleryItemPage.postTitle.getText();
        galleryItemPage.addToFavorites();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.chooseAllFavorites));
        galleryItemPage.chooseNewFolderFavorites();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // go to favorites
        galleryItemPage.showUserMenu();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.toUserFavorites));
        galleryItemPage.gotoFavoritesPage();

        userPostsPage = new UserPostsPage(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        Assert.assertFalse(driver.getPageSource().contains(postTitle));
        userPostsPage.newFolder.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        Assert.assertTrue(driver.getPageSource().contains(postTitle));
        userPostsPage.openFolderSettings();
        wait.until(ExpectedConditions.visibilityOf(userPostsPage.deleteFolder));
        userPostsPage.deleteFolder();

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
