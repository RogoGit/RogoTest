package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostCreationPage {

    public WebDriver driver;

    public PostCreationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class, 'title')]//span[not(@*)]")
    public WebElement currentUserName;

    //@FindBy(xpath = "//a[contains(@href,'posts')]")
    @FindBy(xpath = "//*[text()='Posts']")
    public WebElement toUserPosts;

    @FindBy(xpath = "//*[text()='Delete image']")
    public WebElement deleteImage;

    @FindBy(xpath = "//div[@class='UploadPost-postTitle']//span[contains(@placeholder,'title')]")
    public WebElement postTitle;

    @FindBy(xpath = "//div[contains(@class,'ImageDescription')][contains(@class,'editable')]")
    private WebElement imageDescription;

    @FindBy(xpath = "//div[contains(@class,'imageWrapper')]")
    public WebElement image;

    @FindBy(xpath = "//button[@type='submit'][contains(@title,'Community')]")
    public WebElement toCommunityButton;

    @FindBy(xpath = "//div[contains(@class,'TagAdd')]")
    private WebElement addTagButton;

    @FindBy(xpath = "//div[contains(@class,'TagAdd-active')]")
    public WebElement tagActive;

    @FindBy(xpath = "//button[contains(@class,'confirm--public')]")
    public WebElement confirmPublic;

    @FindBy(xpath = "//img[contains(@class,'delete')]/..")
    public WebElement deletePostButton;

    @FindBy(xpath = "//button[contains(@class,'--do')]")
    public WebElement confirmDelete;

    @FindBy(xpath = "//button[contains(@class,'--accountRemove')]")
    public WebElement confirmImageDelete;

    @FindBy(xpath = "//div[@class='Dropdown image-options']")
    public WebElement imageOptions;

    @FindBy(xpath = "//div[@class='Dropdown-menu ']")
    public WebElement userHrefsDropdown;

    public void addPostTitle(JavascriptExecutor js, String title) {
        postTitle.sendKeys(title);
        //js.executeScript("arguments[0].textContent= arguments[1];", postTitle, title);
    }

    public void addImageDescription(JavascriptExecutor js, String description) {
        imageDescription.sendKeys(description);
        //js.executeScript("arguments[0].textContent= arguments[1];", imageDescription, description);
    }

    public void showUserMenu() {
        currentUserName.click();
    }

    public void gotoPostsPage(JavascriptExecutor js) {
        //js.executeScript("arguments[0].click()",toUserPosts);
        toUserPosts.click();
    }

    public void showImageOptions() {
        imageOptions.click();
    }

    public void deleteImage() {
        deleteImage.click();
    }

    public void confirmImageDelete() {
        confirmImageDelete.click();
    }

    public void deletePost(JavascriptExecutor js) {
        deletePostButton.click();
        //js.executeScript("arguments[0].click();", deletePostButton);
    }

    public void confirmDelete() {
        confirmDelete.click();
    }

    public void clickAddTag() {
        addTagButton.click();
    }

    public void addTag(JavascriptExecutor js, String tag) {
        //tagActive.sendKeys(tag);
        js.executeScript("arguments[0].textContent= arguments[1];", tagActive, tag);
    }

    public void makePostPublic(JavascriptExecutor js) {
        toCommunityButton.click();
        //js.executeScript("arguments[0].click();", toCommunityButton);
    }

    public void confirmPublic(JavascriptExecutor js) {
        confirmPublic.click();
        //js.executeScript("arguments[0].click();", confirmPublic);
    }

}
