package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * Created by Администратор on 13.01.2016.
 */
public class Comment extends AbstractPage{
    private final Logger logger = Logger.getLogger(Comment.class);
    private final String BASE_URL = "http://baskino.club/serial/10995-skorpion.html";

    @FindBy(xpath = "//a[@id='login_button']")
    private WebElement buttonInput;

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//li[@class='buttons']//input[@class='fbutton']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//table[@class='tableform']//tbody//tr//td[@class='editorcomm']//div[@class='editor']//textarea[@id='comments']")
    private WebElement inputComment;

    @FindBy(xpath = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement bottonCaptcha;

    @FindBy(xpath = "//div[@class='fieldsubmit']//button[@class='fbutton']")
    private WebElement bottonAdd;

    @FindBy(xpath = "//div[@class='head']//h2[@class='title']//span")
    private WebElement linkLoggedInUser;

    public Comment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }
    public void addComment(String username, String password) throws InterruptedException {
        buttonInput.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login done");
        logger.info("Login performed");
    }
    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }
}

