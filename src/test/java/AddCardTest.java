import carma.taxi.webPages.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class AddCardTest extends BasePageTest{

    @Test
    public void testAddCard(){
        StartPage startPage = new StartPage(driver);

        open("");
        log.info("Start page is opened.");

        startPage.clickToLoginBtn();
        log.info("Clicked on the Login button");

        LoginPage loginPage = new LoginPage(driver);
        log.info("Login page is opened.");

        Assert.assertTrue(loginPage.isAuthorizationTextDisplayed(), "Authorization text is not displayed.");

        loginPage.clickToOpenFlagDropDown();
        log.info("Clicked on the flag drop down.");

        Assert.assertTrue(loginPage.isTurkeyDisplayed(), "Turkey flag is not displayed.");

        loginPage.loginFlow("956726533", "111111");
        log.info("User is logged in successfully.");

        OrdersPage ordersPage = new OrdersPage(driver);
        log.info("Orders page is opened.");

        ordersPage.clickToMoreTab();
        log.info("More page is opened.");

        MorePage morePage = new MorePage(driver);

        morePage.clickToFinancialManagement();
        log.info("Money page is opened.");

        MoneyPage moneyPage = new MoneyPage(driver);

        moneyPage.clickToAddCard();
        log.info("Wayforpay page is opened.");

        WayforpayPage wayforpayPage = new WayforpayPage(driver);

        Assert.assertTrue(wayforpayPage.isHeaderDisplayed(), "Header is not displayed");

    }
}
