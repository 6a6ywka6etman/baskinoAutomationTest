package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 18.01.2016.
 */
public class DeleteFromFavorite extends AbstractPage{
    private final Logger logger = Logger.getLogger(DeleteFromFavorite.class);
    private final String BASE_URL = "http://armorgames.com/";

    public DeleteFromFavorite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Game page opened");
    }

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@href='/play/14063/wartune']")
    private WebElement buttonGame;

    @FindBy(xpath = "//button[@id='fav-btn']")
    private WebElement buttonFavor;

    public void unfavorite(String unfav) throws InterruptedException {
        inputSearch.sendKeys(unfav);
        buttonSearch.click();
        logger.info("Search done");
        Thread.sleep(2000);
        buttonGame.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        buttonFavor.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        logger.info("Delete from favorite performed");
    }
}
