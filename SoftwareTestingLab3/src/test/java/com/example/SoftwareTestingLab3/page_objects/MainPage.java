package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@class, 'signin')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'UserMenu')]//div[contains(@class, 'title')]//span[not(@*)]")
    public WebElement currentUserName;

    @FindBy(xpath = "//*[text()='Posts']")
    public WebElement toUserPosts;

    @FindBy(xpath = "//*[text()='Favorites']")
    public WebElement toUserFavorites;

    @FindBy(xpath = "//a[contains(@href,'/gallery/')]")
    public WebElement firstVideoInGallery;

    @FindBy(xpath = "(//a[contains(@href,'/gallery/')])[2]")
    public WebElement secondVideoInGallery;

    @FindBy(xpath = "//a[contains(@href,'upload')]")
    public WebElement newPostButton;

    public void goToLoginPage() {
        loginButton.click();
    }

    public String getCurrentUserName() {
        return currentUserName.getText();
    }

    public void goToUpload() {
        newPostButton.click();
    }

    public void showUserMenu() {
        currentUserName.click();
    }

    public void gotoPostsPage() {
        toUserPosts.click();
    }

    public void gotoFavoritesPage() {
        toUserFavorites.click();
    }

    public String getFirstVideoInGalleryPath() {
        return firstVideoInGallery.getAttribute("href");
    }

    public void goToFirstVideoInGallery() {
        firstVideoInGallery.click();
    }

    public void goToSecondVideoInGallery() {secondVideoInGallery.click();}

}
