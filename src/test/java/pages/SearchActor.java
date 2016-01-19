package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 18.01.2016.
 */
public class SearchActor extends AbstractPage{
    private final Logger logger = Logger.getLogger(SearchActor.class);
    private final String BASE_URL = "http://baskino.club";

    public SearchActor(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Search page opened");
    }

    @FindBy(xpath = "//form[@id='search']//fieldset[@id='find']//div//span[@class='bg']//input[@id='story']")
    private WebElement inputSearch;

    @FindBy(xpath = "//form[@id='search']//fieldset[@id='find']//div//a[@class='find-button']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='search-actors_result']//div[@class='list clearfix']//a[@href='http://baskino.club/actors/%C4%E6%EE%ED%ED%E8+%C4%E5%EF%EF/']//b")
    private WebElement linkActor;

    public void searchAct(String searchA) throws InterruptedException {
        inputSearch.sendKeys(searchA);
        buttonSearch.click();
        Thread.sleep(2000);
        logger.info("Search done");
        logger.info("Search performed");
    }
    public String getSearchActor()
    {
        return linkActor.getText();
    }
}
