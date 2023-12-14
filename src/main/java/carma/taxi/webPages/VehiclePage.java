package carma.taxi.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePage extends BasePage{

    @FindBy(xpath = "//*[@class='link_add_cars']")
    protected WebElement addVehicleBtn;

    public VehiclePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfCars(WebDriver driver) {
        waitForSeconds(3);
        return driver.findElements(By.cssSelector(".block_list .nav-list_cars"));

    }

    public void clickToAddVehicle(){
        waitForVisibility(addVehicleBtn);
        addVehicleBtn.click();
    }

    public List<WebElement> getUpdatedListOfCars(WebDriver driver) {
        waitForSeconds(3);
        return driver.findElements(By.cssSelector(".block_list .nav-list_cars"));

    }

    public boolean isNewCarAdded(List<WebElement> initialCarList, List<WebElement> updatedCarList) {

        if (updatedCarList.size() != initialCarList.size() + 1) {
            return false;
        }

        for (WebElement updatedCar : updatedCarList) {
            if (!initialCarList.contains(updatedCar)) {
                return true;
            }
        }
        return false;
    }

    public void openNewCarPage(WebDriver driver) {
        waitForSeconds(3);
        List<WebElement> updatedCarList = getUpdatedListOfCars(driver);

        if (!updatedCarList.isEmpty()) {
            List<WebElement> nonSelectedCars = updatedCarList.stream()
                    .filter(car -> car.findElements(By.cssSelector(".block_list .Mui-checked")).isEmpty())
                    .collect(Collectors.toList());

            if (!nonSelectedCars.isEmpty()) {
                System.out.println("Updated Car List (excluding selected car): " + nonSelectedCars);
                WebElement newCar = nonSelectedCars.get(0);

                waitForSeconds(3);
                newCar.click();
            } else {
                throw new RuntimeException("No other car found in the updated car list.");
            }
        } else {
            throw new RuntimeException("No cars found in the updated car list.");
        }
    }

}
