package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GalleryItemPage {

    public WebDriver driver;

    public GalleryItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class,'score')]//span[contains(@title,'Score')]")
    public WebElement totalScore;

    @FindBy(xpath = "//div[contains(@class,'btn-upvote')]/*[local-name() = 'svg']")
    private WebElement upVotePostSvg;

    @FindBy(xpath = "//div[contains(@class,'btn-downvote')]/*[local-name() = 'svg']")
    private WebElement downVotePostSvg;

    @FindBy(xpath = "//div[contains(@class,'Gallery-Sidebar')]")
    public WebElement gallerySlideBar;

    // post voting

    public Integer getTotalPostScore() {
        try {
            return Integer.parseInt(totalScore.getText().replace(",",""));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public void upVotePost() {
        upVotePostSvg.click();
    }

    public void downVotePost() {
        downVotePostSvg.click();
    }

}
