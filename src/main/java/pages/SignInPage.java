package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends CommonElements {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(@class,'validation-error')]")
    private WebElement emailValidationError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailInEmailField(String email) {
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }

    public void enterPasswordInPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButtonOnSingOnPage() {
        signInButton.click();
    }

    public boolean isEmailValidationErrorVisible() {
        return emailValidationError.isDisplayed();
    }
}
