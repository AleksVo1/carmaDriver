package carma.taxi.webPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(xpath = "//*[@class='login-title__register']")
    protected WebElement registerTitle;

    @FindBy(xpath = "//*[@class='Input phone_input']")
    protected WebElement phoneNumber;

    @FindBy(xpath = "(//*[@class='Input input_field'])[1]")
    protected WebElement firstName;

    @FindBy(xpath = "(//*[@class='Input input_field'])[2]")
    protected WebElement lastName;

    @FindBy(xpath = "//*[@name='email']")
    protected WebElement email;

    @FindBy(xpath = "//*[@class='Button block-select']")
    protected WebElement selectCity;

    By selectRandomCity = By.cssSelector(".Wrapper .block-select_menu .nav-menu li");

    @FindBy(xpath = "//*[@class='back_icon']")
    protected WebElement closeCity;

    @FindBy(xpath = "//*[@name='password']")
    protected WebElement password;

    @FindBy(xpath = "//*[@name='cpassword']")
    protected WebElement repeatPassword;

    @FindBy(xpath = "//*[@class='Button next-btn']")
    protected WebElement continueBtn;

    @FindBy(xpath = "//*[@class='verefication-title__auth']")
    protected WebElement codeText;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerFlow(String password1, String repeatPassword1){
        Faker faker = new Faker();

        String emailGenerator = generateRandomEmail();

        phoneNumber.click();
        String phoneNumberF = faker.phoneNumber().phoneNumber();
        phoneNumber.sendKeys(phoneNumberF);

        firstName.click();
        String firstNameF = faker.name().firstName();
        firstName.sendKeys(firstNameF);

        lastName.click();
        String lstNameF = faker.name().lastName();
        firstName.sendKeys(lstNameF);

        email.click();
        email.sendKeys(emailGenerator);

        selectCity.click();
        selectRandomElement(driver, selectRandomCity);
        closeCity.click();

        password.click();
        password.sendKeys(password1);

        repeatPassword.click();
        repeatPassword.sendKeys(repeatPassword1);

        waitForVisibility(continueBtn);
        continueBtn.click();
    }

    public boolean isRegisterTextDisplayed(){
        waitForVisibility(registerTitle);
        return registerTitle.isDisplayed();
    }

    public boolean isCodeTextDisplayed(){
        waitForVisibility(codeText);
        return codeText.isDisplayed();
    }
}
