package carma.taxi.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AddVehiclePage extends BasePage{

    @FindBy(xpath = "(//*[@class='Button btn-select'])[1]")
    protected WebElement vehicleMake;

    @FindBy(xpath = "(//*[@class='Button btn-select'])[2]")
    protected WebElement vehicleModel;

    @FindBy(xpath = "(//*[@class='Button btn-select'])[3]")
    protected WebElement vehicleYear;

    @FindBy(xpath = "(//*[@class='Button btn-select'])[4]")
    protected WebElement vehicleColor;

    @FindBy(xpath = "//*[@name='number']")
    protected WebElement vehicleNumber;

    @FindBy(xpath = "(//*[@class='Button btn-select'])[5]")
    protected WebElement vehicleClass;

    @FindBy(xpath = "(//*[@class='arrowleft_icon'])[1]")
    protected WebElement closeButton;

    By list = By.cssSelector(".Wrapper .block-select_menu .nav-menu li");

    @FindBy(xpath = "(//ul[@class='prefs-list']/li)[1]")
    protected WebElement carCigarette;

    @FindBy(xpath = "(//ul[@class='prefs-list']/li)[2]")
    protected WebElement childSeat;

    @FindBy(xpath = "(//ul[@class='prefs-list']/li)[3]")
    protected WebElement delivery;

    @FindBy(xpath = "(//ul[@class='prefs-list']/li)[4]")
    protected WebElement pet;

    @FindBy(xpath = "//*[@class='Button confirm_btn']")
    protected WebElement confirmButton;

    public AddVehiclePage(WebDriver driver) {
        super(driver);
    }

    public void addVehicle(String number){
        waitForVisibility(vehicleMake);
        vehicleMake.click();
        selectRandomElement(driver, list);
        closeButton.click();

        vehicleModel.click();
        selectRandomElement(driver, list);
        closeButton.click();

        vehicleYear.click();
        selectRandomElement(driver, list);
        closeButton.click();

        vehicleColor.click();
        selectRandomElement(driver, list);
        closeButton.click();

        enterText(vehicleNumber, number);

        vehicleClass.click();
        selectRandomElement(driver, list);
        closeButton.click();

        carCigarette.click();
        childSeat.click();
        delivery.click();
        pet.click();

        waitForVisibility(confirmButton);
        confirmButton.click();

    }

}
