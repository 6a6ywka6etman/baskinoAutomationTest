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
        private final String BASE_URL = "http://armorgames.com/";

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Search page opened");
    }

        @FindBy(xpath = "//input[@id='search-input']")
        private WebElement inputSearch;

        @FindBy(xpath = "//button[@type='submit']")
        private WebElement buttonSearch;

        @FindBy(xpath = "//p[@class='desc']//strong")
        private WebElement linkGAME;

        public void search(String search) throws InterruptedException {
            inputSearch.sendKeys(search);
            buttonSearch.click();
            Thread.sleep(2000);
            logger.info("Search done");
            logger.info("Search performed");
        }
        public String getSearchName()
        {
            return linkGAME.getText();
        }
    }
