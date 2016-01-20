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
    private final String BASE_URL = "http://armorgames.com/";

    @FindBy(xpath = "//input[@id='username-input']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password-input']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//span[@class='username']")
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
    public void login(String username, String password) throws InterruptedException {

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonLogin.click();
        logger.info("Login done");
        Thread.sleep(2000);
        logger.info("Login performed");
    }
    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }
}

