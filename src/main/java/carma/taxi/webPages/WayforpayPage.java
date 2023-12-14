package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WayforpayPage extends BasePage{

    @FindBy(xpath = "//*[@class='text-center page-title']")
    protected WebElement header;

    public WayforpayPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed(){
        return header.isDisplayed();
    }
}
