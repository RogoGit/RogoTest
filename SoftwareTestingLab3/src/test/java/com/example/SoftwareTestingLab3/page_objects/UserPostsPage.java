package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@class='ProfileMeta-user']")
    public WebElement userNameTitle;

    @FindBy(xpath = "(//a[@class='Post-item novote'])")
    public WebElement firstPost;

    @FindBy(xpath = "//a[text()='all']")
    public WebElement all;

    @FindBy(xpath = "//div[@class='FavoritesPost']//a")
    public WebElement firstFavoritePost;

    @FindBy(xpath = "//div[contains(@class,'OutlineFolder')]//div[@class='Folder-Icon']")
    public WebElement createNewFolder;

    @FindBy(xpath = "//form[contains(@class,'FavoritesLabel')]")
    public WebElement newFolderName;

    @FindBy(xpath = "//div[@class='Folder PickerFolder']//label[text()='New Folder']")
    public WebElement newFolder;

    @FindBy(xpath = "//div[contains(@class,'Favorite')]//img[@class='settings']")
    public WebElement folderSettings;

    @FindBy(xpath = "//a[text()='Delete Folder']")
    public WebElement deleteFolder;

    @FindBy(xpath = "//div[@class='FavoritesPost']//div[@class='Post-item-title']//span")
    public WebElement postInNewFolder;

    public void openFolderSettings() {
        folderSettings.click();
    }

    public void deleteFolder() {
        deleteFolder.click();
    }

    public void goToFirstPost() {
        firstPost.click();
    }

    public void gotoAll() {
        all.click();
    }

    public void gotoFirstFavorite() {
        firstFavoritePost.click();
    }

    public String getPostHref(WebElement post) {
        return post.getAttribute("href").split("/")[5];
    }

    public void addNewFolder() {
        createNewFolder.click();
    }

    public void nameNewFolder(JavascriptExecutor js, String name) {
        js.executeScript("arguments[0].textContent= arguments[1];", newFolderName, name);
        newFolderName.submit();
        //userNameTitle.click();
        //newFolderName.sendKeys(name);
    }

}
