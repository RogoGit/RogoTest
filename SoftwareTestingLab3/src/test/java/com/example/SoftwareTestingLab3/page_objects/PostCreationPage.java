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

    @FindBy(xpath = "//div[@class='UploadPost-postTitle']//span[contains(@placeholder,'title')]")
    private WebElement postTitle;

    @FindBy(xpath = "//div[contains(@class,'ImageDescription')][contains(@class,'editable')]")
    private WebElement imageDescription;

    @FindBy(xpath = "//button[@type='submit'][contains(@title,'Community')]")
    public WebElement toCommunityButton;

    @FindBy(xpath = "//div[contains(@class,'TagAdd')]")
    private WebElement addTagButton;

    @FindBy(xpath = "//div[contains(@class,'TagAdd-active')]")
    public WebElement tagActive;

    @FindBy(xpath = "//button[contains(@class,'confirm--public')]")
    public WebElement confirmPublic;

    public void addPostTitle(JavascriptExecutor js, String title) {
        postTitle.sendKeys(title);
        //js.executeScript("arguments[0].textContent= arguments[1];", postTitle, title);
    }

    public void addImageDescription(JavascriptExecutor js, String description) {
        imageDescription.sendKeys(description);
        //js.executeScript("arguments[0].textContent= arguments[1];", imageDescription, description);
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
