import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class BaskinoAutomationTest {

      private Steps steps;
    private final String USERNAME = "autotest";
    private final String PASSWORD = "Sv_gravity100";
    private final String SEARCHGAME="wartune";
    private final String BIO="i love games";
    private final String FAV="Wartune";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanLoginArmor() throws InterruptedException {
        steps.loginArmorGames(USERNAME,PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test
    public void searchGameArmor() throws InterruptedException{
        steps.loginArmorGames(USERNAME,PASSWORD);
        steps.searchGame(SEARCHGAME);
        Assert.assertTrue(steps.isSearch(SEARCHGAME));
    }

    @Test
    public void bioArmor() throws InterruptedException{
        steps.loginArmorGames(USERNAME,PASSWORD);
        steps.addBio(BIO);
        Assert.assertTrue(steps.isBio(BIO));
    }

    @Test
    public void AddFavArmor() throws InterruptedException{
        steps.loginArmorGames(USERNAME,PASSWORD);
        steps.addFav(FAV);
        Assert.assertTrue(steps.isFav(FAV));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
