package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Администратор on 18.01.2016.
 */
    public class SearchPage extends AbstractPage{
        private final Logger logger = Logger.getLogger(SearchPage.class);
        private final String BASE_URL = "http://baskino.club";

    public SearchPage(WebDriver driver) {
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

        @FindBy(xpath = "//div[@class='posttitle']//a[@href='http://baskino.club/films/komedii/13056-lobster.html']")
        private WebElement linkMovie;

        public void search(String search) throws InterruptedException {
            inputSearch.sendKeys(search);
            buttonSearch.click();
            Thread.sleep(2000);
            logger.info("Search done");
            logger.info("Search performed");
        }
        public String getSearchName()
        {
            return linkMovie.getText();
        }
    }
