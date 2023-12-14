package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends BasePage{

    @FindBy(xpath = "//*[@href='/dashboard']")
    protected WebElement moreTab;

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public void clickToMoreTab(){
        waitForVisibility(moreTab);
        moreTab.click();
    }
}
