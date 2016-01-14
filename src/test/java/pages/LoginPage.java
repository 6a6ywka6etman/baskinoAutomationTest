package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * Created by Администратор on 13.01.2016.
 */
public class LoginPage extends AbstractPage{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://baskino.club";

    @FindBy(xpath = "//a[@id='login_button']")
    private WebElement buttonInput;

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//li[@class='buttons']//input[@class='fbutton']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//ul[@class='user']//li//a[@id='login_button']")
    private WebElement buttonAcc;

    @FindBy(xpath = "//ul[@class='user_logged_list']//li[contains(a,'/user')]")
    private WebElement buttonAccaunt;

    @FindBy(xpath = "//div[@class='head']//h2[@class='title']//span")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }
    public void login(String username, String password)
    {
        buttonInput.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        buttonAcc.click();
        buttonAccaunt.click();
        logger.info("Login performed");
    }
    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }
}

