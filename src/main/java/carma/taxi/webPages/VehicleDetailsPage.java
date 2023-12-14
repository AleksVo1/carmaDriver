package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VehicleDetailsPage extends BasePage{

    @FindBy(xpath = "(//*[@class='brand'])[1]")
    protected WebElement brandName;

    @FindBy(xpath = "//*[@class='Button defaultcar_btn']")
    protected WebElement defaultBtn;

    @FindBy(xpath = "//*[@class='Button change_btn']")
    protected WebElement changeBtn;

    @FindBy(css = ".modal .modalalert-section .alert-text")
    protected WebElement alertTextPopUp;

    @FindBy(css = ".modal .modalalert-section .alert-buttons")
    protected WebElement closePopUp;

    @FindBy(css = ".cars-section .container .remove-auto_block .remove_btn")
    protected WebElement deleteBtn;

    @FindBy(css = ".modalconfirm-section .confirm-buttons button:first-child")
    protected WebElement confirmDelete;

    public VehicleDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBrandNameDisplayed(){
        waitForVisibility(brandName);
        return brandName.isDisplayed();
    }

    public void clickToDefaultBtn(){
        waitForVisibility(defaultBtn);
        defaultBtn.click();
    }

    public boolean isTextAlertDisplayed(){
        waitForVisibility(alertTextPopUp);
        return alertTextPopUp.isDisplayed();
    }

    public void clickToCloseAlert(){
        Actions actions = new Actions(driver);
        actions.moveToElement(closePopUp).click().perform();
    }

    public boolean isChangeBtnDisplayed(){
        waitForVisibility(changeBtn);
        return changeBtn.isDisplayed();
    }

    public void deleteVehicle(){
        waitForVisibility(deleteBtn);
        deleteBtn.click();
    }

    public void clickYesInModal(){
        waitForSeconds(2);
        scrollToElement(confirmDelete);
        confirmDelete.click();
    }

}
