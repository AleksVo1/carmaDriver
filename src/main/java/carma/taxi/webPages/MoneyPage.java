package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoneyPage extends BasePage{

    @FindBy(xpath = "//*[@class='add-card add_card_btn_input']")
    protected WebElement addCard;
    public MoneyPage(WebDriver driver) {
        super(driver);
    }

    public void clickToAddCard(){
        waitForVisibility(addCard);
        addCard.click();
    }
}
