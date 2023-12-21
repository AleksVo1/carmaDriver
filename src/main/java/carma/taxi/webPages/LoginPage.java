package carma.taxi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@class='selected-flag']")
    protected WebElement flagDropDown;

    @FindBy(xpath = "//*[@class='Input styles_inputPhone__X9v6h ']")
    protected WebElement phoneField;

    @FindBy(xpath = "//*[@class='Button continue_btn']")
    protected WebElement continueBtn;

    @FindBy(xpath = "//*[@class='Input pass_input']")
    protected WebElement passwordField;

    @FindBy(xpath = "//*[@class='Button']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//*[@class='login-title__auth']")
    protected WebElement authorizationText;

    @FindBy(xpath = "//*[text()='Turkey']")
    protected WebElement turkeyFlag;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickToOpenFlagDropDown(){
        waitForVisibility(flagDropDown);
        flagDropDown.click();
    }

    public void clickToPhoneField(){
        waitForVisibility(phoneField);
        phoneField.click();
    }

    public void clickToContinueBtn(){
        waitForVisibility(continueBtn);
        continueBtn.click();
    }

    public void clickToPasswordField(){
        waitForVisibility(passwordField);
        passwordField.click();
    }

    public void clickToLoginBtn(){
        waitForVisibility(loginBtn);
        loginBtn.click();
    }

    public void loginFlow(String phone, String password){
        waitForVisibility(phoneField);
        phoneField.click();
        enterText(phoneField, phone);
        waitForVisibility(continueBtn);
        continueBtn.click();
        waitForVisibility(passwordField);
        passwordField.click();
        enterText(passwordField, password);
        waitForVisibility(loginBtn);
        loginBtn.click();
    }

    public boolean isAuthorizationTextDisplayed(){
        waitForVisibility(authorizationText);
        return authorizationText.isDisplayed();
    }

    public boolean isTurkeyDisplayed(){
        waitForVisibility(turkeyFlag);
        return turkeyFlag.isDisplayed();
    }

}
