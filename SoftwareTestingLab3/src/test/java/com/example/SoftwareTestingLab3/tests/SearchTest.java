package com.example.SoftwareTestingLab3.tests;

import com.example.SoftwareTestingLab3.page_objects.*;
import com.example.SoftwareTestingLab3.web_helpers.BrowsersList;
import com.example.SoftwareTestingLab3.web_helpers.DriverManager;
import com.example.SoftwareTestingLab3.web_helpers.URLConstants;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {

    private WebDriver driver;

    @ParameterizedTest
    @EnumSource(BrowsersList.class)
    public void testSearch(BrowsersList browser) {

        MainPage mainPage;
        SearchResultsPage searchResultsPage;
        GalleryItemPage galleryItemPage;
        UserPostsPage userPostsPage;

        driver = DriverManager.setUpDriver(browser);
        mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOf(mainPage.searchInput));
        // search for tag
        mainPage.searchFor("#funny");
        mainPage.submitSearch();
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.goToFirstResult();

        galleryItemPage = new GalleryItemPage(driver);
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.postTitle));
        Assert.assertNotNull("required tag not found",galleryItemPage.specialTag);

        // search for user
        driver.get(URLConstants.BASE_URL);
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchInput));
        mainPage.searchFor("@notbanmepls");
        wait.until(ExpectedConditions.visibilityOf(mainPage.suggestedItem));
        mainPage.chooseSuggestedItem();

        userPostsPage = new UserPostsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(userPostsPage.userNameTitle));
        Assert.assertEquals("wrong username", "notbanmepls", userPostsPage.userNameTitle.getText());

        // search for post
        driver.get(URLConstants.BASE_URL);
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchInput));
        mainPage.searchFor("Just a beautiful sunny day");
        mainPage.submitSearch();

        searchResultsPage.goToFirstResult();
        wait.until(ExpectedConditions.visibilityOf(galleryItemPage.postTitle));
        Assert.assertEquals("wrong post found", "Just a beautiful sunny day", galleryItemPage.postTitle.getText());

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
