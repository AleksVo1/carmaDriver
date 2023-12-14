package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MorePage extends BasePage{

    @FindBy(xpath = "//*[@href='/money']")
    protected WebElement financialManagement;

    @FindBy(xpath = "//*[@href='/cars']")
    protected WebElement vehicle;

    public MorePage(WebDriver driver) {
        super(driver);
    }

    public void clickToFinancialManagement(){
        waitForVisibility(financialManagement);
        financialManagement.click();
    }

    public void clickToVehicle(){
        waitForVisibility(vehicle);
        vehicle.click();
    }
}
