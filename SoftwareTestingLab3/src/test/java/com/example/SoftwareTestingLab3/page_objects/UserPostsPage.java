package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPostsPage {

    public WebDriver driver;

    public UserPostsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='Post-item-container']//div[contains(@class,'item-title')]//span")
    public WebElement firstPostTitle;

    @FindBy(xpath = "//a[@class='Post-item novote']")
    public WebElement firstPost;

    @FindBy(xpath = "//a[text()='all']")
    public WebElement all;

    public void goToFirstPost() {
        firstPost.click();
    }

    public void gotoAll() {
        all.click();
    }

}
