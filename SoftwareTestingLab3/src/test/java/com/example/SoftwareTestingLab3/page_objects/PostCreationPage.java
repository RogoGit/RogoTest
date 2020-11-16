package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.JavascriptExecutor;
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

    public void addPostTitle(JavascriptExecutor js, String title) {
        js.executeScript("arguments[0].textContent= arguments[1];", postTitle, title);
    }

    public void addImageDescription(JavascriptExecutor js, String description) {
        js.executeScript("arguments[0].textContent= arguments[1];", imageDescription, description);
    }

}
