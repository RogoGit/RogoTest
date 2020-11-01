package com.example.SoftwareTestingLab3.page_objects;

import com.example.SoftwareTestingLab3.web_helpers.UserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void login() {
        usernameInput.sendKeys(UserCredentials.username);
        passwordInput.sendKeys(UserCredentials.password);
        loginButton.click();
    }

}
