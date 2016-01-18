import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * Created by Администратор on 13.01.2016.
 */
public class BaskinoAutomationTest {

      private Steps steps;
    private final String USERNAME = "adminnn";
    private final String PASSWORD = "adminnn";
    private final String SEARCHMOVIE="Scorpion";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanLoginBaskino() throws InterruptedException {
        steps.loginBaskino(USERNAME,PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test
    public void searchMovieBaskino() throws InterruptedException{
        steps.searchMovie(SEARCHMOVIE);
        Assert.assertTrue(steps.isSearch(SEARCHMOVIE));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
