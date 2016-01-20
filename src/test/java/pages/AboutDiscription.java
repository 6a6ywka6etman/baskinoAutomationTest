package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutDiscription extends AbstractPage{
    private final Logger logger = Logger.getLogger(AboutDiscription.class);
    private final String BASE_URL = "http://armorgames.com/settings/general";

    @FindBy(xpath = "//textarea[@id='bio-input']")
    private WebElement inputBio;

    @FindBy(xpath = "//button[@id='save-settings-btn']")
    private WebElement buttonSave;

    @FindBy(xpath = "//span[@class='username']")
    private WebElement buttonUser;

    @FindBy(xpath = "//div[@id='main']//div[@id='userinfo']//div[@id='userabout']//div[@id='about']//p")
    private WebElement linkBio;

    public AboutDiscription(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Bio settings page opened");
    }
    public void discription(String bio) throws InterruptedException{
        inputBio.clear();
        inputBio.sendKeys(bio);
        buttonSave.click();
        logger.info("bio added");
        buttonUser.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        logger.info("bio performed");
    }
    public String getUserBio()
    {
        return linkBio.getText();
    }
}


