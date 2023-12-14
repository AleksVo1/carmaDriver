import carma.taxi.webPages.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class AddVehicleTest extends BasePageTest{

    @Test
    public void testAddVehicle() {
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

        morePage.clickToVehicle();
        log.info("Clicked on the vehicle.");

        VehiclePage vehiclePage = new VehiclePage(driver);

        List<WebElement> initialCarList = new VehiclePage(driver).getListOfCars(driver);
        log.info("Get a list of cars.");

        vehiclePage.clickToAddVehicle();
        log.info("Clicked on the add vehicle.");

        AddVehiclePage addVehiclePage = new AddVehiclePage(driver);
        addVehiclePage.addVehicle("FF6677KK");
        log.info("Vehicle is added.");

        List<WebElement> updatedCarList = new VehiclePage(driver).getUpdatedListOfCars(driver);
        log.info("Get updated list of cars.");

        boolean isNewCarAdded = vehiclePage.isNewCarAdded(initialCarList, updatedCarList);
        log.info("Checked that a new car has been added.");

        Assert.assertTrue(isNewCarAdded, "New car is not added.");

        VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage(driver);

        vehiclePage.openNewCarPage(driver);
        log.info("Newly added car page is opened.");

        vehicleDetailsPage.clickToDefaultBtn();
        log.info("Clicked on the default button.");

        Assert.assertTrue(vehicleDetailsPage.isTextAlertDisplayed(), "Vehicle is not set as default");

        vehicleDetailsPage.clickToCloseAlert();
        log.info("Modal is closed.");

        Assert.assertTrue(vehicleDetailsPage.isChangeBtnDisplayed(), "Change button is not displayed.");

        vehicleDetailsPage.deleteVehicle();
        log.info("Clicked to deleted vehicle.");

        vehicleDetailsPage.clickYesInModal();
        log.info("Vehicle has been successfully deleted.");

    }
}
