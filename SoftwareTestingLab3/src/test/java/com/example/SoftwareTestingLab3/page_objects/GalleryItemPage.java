package com.example.SoftwareTestingLab3.page_objects;

import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[contains(@class,'UserMenu')]//div[contains(@class, 'title')]//span[not(@*)]")
    public WebElement currentUserName;

    @FindBy(xpath = "//*[text()='Posts']")
    public WebElement toUserPosts;

    @FindBy(xpath = "//*[text()='Favorites']")
    public WebElement toUserFavorites;

    @FindBy(xpath = "//div[contains(@class,'Gallery-Title')]//span")
    public WebElement postTitle;

    @FindBy(xpath = "//div[contains(@class,'Gallery-Content')][contains(@class,'descr')]//span[@class='Linkify']")
    public WebElement postDescription;

    @FindBy(xpath = "//div[contains(@class,'score')]//span[contains(@title,'Score')]")
    public WebElement totalScore;

    @FindBy(xpath = "//div[contains(@class,'btn-upvote')]/*[local-name() = 'svg']")
    private WebElement upVotePostSvg;

    @FindBy(xpath = "//div[contains(@class,'btn-downvote')]/*[local-name() = 'svg']")
    private WebElement downVotePostSvg;

    @FindBy(xpath = "//div[contains(@class,'Gallery-Sidebar')]")
    public WebElement gallerySlideBar;

    @FindBy(xpath = "//div[@class='Gallery-Content']//img")
    public WebElement postImage;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//div[contains(@class,'points')]")
    public WebElement totalCommentPoints;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//div[contains(@class,'vote-btn up')]/*[local-name() = 'svg']")
    private WebElement upVoteCommentSvg;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//div[contains(@class,'vote-btn down')]/*[local-name() = 'svg']")
    private WebElement downVoteCommentSvg;

    @FindBy(xpath = "//div[contains(@class,'favorite')]/*[local-name() = 'svg']")
    private WebElement addToFavoritesSvg;

    @FindBy(xpath = "//*[text()='All Favorites']")
    public WebElement chooseAllFavorites;

    @FindBy(xpath = "//*[text()='New Folder']")
    public WebElement chooseNewFolderFavorites;

    @FindBy(xpath = "//form[contains(@class,'Comment-create')]//textarea[contains(@class,'Comment-create')]")
    public WebElement commentWriteSection;

    @FindBy(xpath = "//form[contains(@class,'Comment-create')]//button[@type='submit']")
    public WebElement postCommentButton;

    @FindBy(xpath = "//div[@class='CommentsList-comments']")
    public WebElement commentsListSection;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]" +
            "//div[contains(@class,'Meta')]//a[@class='author-name'][text()='notbanmepls']")
    public WebElement commentByAuthor;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//span[@class='Linkify']")
    public WebElement commentBody;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//div[contains(@class,'Dropdown-title')]/*[local-name() = 'svg']")
    public WebElement commentDropdown;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//div[contains(@class,'Dropdown-menu')]//span[text()='Delete']/..")
    public WebElement commentDeleteButton;

    @FindBy(xpath = "//div[contains(@class,'DeleteCommentDialog')]//button[@type='submit'][contains(@title,'Delete')]")
    public WebElement confirmCommentDeleteButton;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//button[contains(@class,'reply')]")
    public WebElement replyToCommentButton;

    @FindBy(xpath = "//div[@class='GalleryComment-reply']//textarea[contains(@placeholder,'reply')]")
    public WebElement replyWriteArea;

    @FindBy(xpath = "//div[@class='GalleryComment-reply']//button[@type='submit']")
    public WebElement postReplyButton;

    @FindBy(xpath = "//div[contains(@class,'GalleryComment')]//button[@class='toggle-replies actions-btn']")
    public WebElement showReplies;

    @FindBy(xpath = "//div[@class='GalleryComment-replies']")
    public WebElement commentReply;

    @FindBy(xpath = "//a[contains(@href,'/t/mysterious_glitch')]")
    public WebElement specialTag;

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

    public void addToFavorites() {
        addToFavoritesSvg.click();
    }

    public void showUserMenu() {
        currentUserName.click();
    }

    public void gotoPostsPage() {
        toUserPosts.click();
    }

    public void gotoFavoritesPage() {
        toUserFavorites.click();
    }

    public void chooseAllFavorites() {
        chooseAllFavorites.click();
    }

    public void chooseNewFolderFavorites() {
        chooseNewFolderFavorites.click();
    }

    // comment voting

    public Integer getTotalCommentPoints() {
        try {
            return Integer.parseInt(totalCommentPoints.getText().replace(",",""));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public void upVoteComment() {
        upVoteCommentSvg.click();
    }

    public void downVoteComment() {
        downVoteCommentSvg.click();
    }

    // comment deleting

    public void showCommentActionsMenu() {
        commentDropdown.click();
    }

    public void deleteComment(JavascriptExecutor js) {
        js.executeScript("arguments[0].click();", this.commentDeleteButton);
        //commentDeleteButton.click();
    }

    public void confirmCommentDelete() {
        confirmCommentDeleteButton.click();
    }

    // comment replying
    public void replyToComment() {
        replyToCommentButton.click();
    }

    public void postReply() {
        postReplyButton.click();
    }

    public void showReplies() {
        showReplies.click();
    }

}
