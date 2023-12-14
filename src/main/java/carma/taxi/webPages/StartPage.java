package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage{

    @FindBy(xpath = "//*[@href='/login']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//*[@class='auth-link auth-btn-register--link']")
    protected WebElement registerBtn;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void clickToLoginBtn(){
        waitForVisibility(loginBtn);
        loginBtn.click();
    }

    public void clickToRegisterBtn(){
        waitForVisibility(registerBtn);
        registerBtn.click();
    }

}
