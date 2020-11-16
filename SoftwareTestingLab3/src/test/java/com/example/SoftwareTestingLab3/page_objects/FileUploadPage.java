package com.example.SoftwareTestingLab3.page_objects;

import com.example.SoftwareTestingLab3.web_helpers.URLConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    public WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    public void uploadImage() {
        fileInput.sendKeys(URLConstants.TEST_IMAGE_PATH);
    }

}
