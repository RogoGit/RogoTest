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
    private WebElement totalScore;

    @FindBy(xpath = "//div[contains(@class,'btn-upvote')]/*[local-name() = 'svg']")
    private WebElement upVotePostSvg;

    @FindBy(xpath = "//div[contains(@class,'btn-downvote')]/*[local-name() = 'svg']")
    private WebElement downVotePostSvg;

    // post voting

    public Integer getTotalPostScore() {
        return Integer.parseInt(totalScore.getText());
    }

    public void upVotePost() {
        upVotePostSvg.click();
    }

    public void downVotePost() {
        downVotePostSvg.click();
    }

}
