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

    @FindBy(xpath = "//div[contains(@class, 'title')]//span[not(@*)]")
    public WebElement currentUserName;

    @FindBy(xpath = "//a[contains(@href,'/gallery/')]")
    private WebElement firstVideoInGallery;

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

    public String getFirstVideoInGalleryPath() {
        return firstVideoInGallery.getAttribute("href");
    }

    public void goToFirstVideoInGallery() {
        firstVideoInGallery.click();
    }

}
