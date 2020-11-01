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
    private WebElement currentUserName;

    public void goToLoginPage() {
        loginButton.click();
    }

    public String getCurrentUserName() {
        return currentUserName.getText();
    }

}
