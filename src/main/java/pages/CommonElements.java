package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CommonElements extends BasePage {

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'kH5PAAC')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='miniBagDropdown']")
    private WebElement filledBagButton;

    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement unFilledBagButton;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement miniBagDropdown;

    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _12h15d-']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//span[@type='heartUnfilled']")
    private WebElement savedItemsButton;

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    private WebElement myAccountDropdown;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinButton;

    @FindBy(xpath = "//div[@class='_25L--Pi']//button[@class='w9hgW1d _19PGtzt']")
    private WebElement preferencesButton;

    @FindBy(xpath = "//div[@class='_3bZNClC']")
    private WebElement preferencesPopup;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countrySelectDropdownOnPreferencesPopup;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencySelectDropDownOnPreferencesPopup;

    @FindBy(xpath = "//button[@class='_3jBV0Hh _2h9sodS']")
    private WebElement updatePreferencesButtonOnPreferencesPopup;

    @FindBy(xpath = "//a[@class='_1cQFCx2' and contains(text(),'Help')]")
    private WebElement helpAndFAQMenuButton;

    @FindBy(xpath = "//div[@id='chrome-sticky-header']")
    private WebElement header;

    @FindBy(xpath = "//div[@id='chrome-footer']")
    private WebElement footer;

    public CommonElements(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void enterTextInSearchField(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public WebElement getFilledBagButton() {
        return filledBagButton;
    }

    public void clickOnFilledBagButton() {
        filledBagButton.click();
    }

    public boolean isUnFilledBagVisible() {
        return unFilledBagButton.isDisplayed();
    }

    public WebElement getMiniBagDropdown() {
        return miniBagDropdown;
    }

    public WebElement getViewBagButton() {
        return viewBagButton;
    }

    public void clickOnViewBagButton() {
        viewBagButton.click();
    }

    public boolean isSavedItemsButtonVisible() {
        return savedItemsButton.isDisplayed();
    }

    public void clickOnSavedItemsButton() {
        savedItemsButton.click();
    }

    public void clickOnMyAccountButton() {
        getActions().moveToElement(myAccountButton).click().pause(Duration.ofSeconds(1)).build().perform();
    }

    public WebElement getMyAccountDropdown() {
        return myAccountDropdown;
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean isJoinButtonVisible() {
        return joinButton.isDisplayed();
    }

    public boolean isMyAccountButtonVisible() {
        return myAccountButton.isDisplayed();
    }

    public boolean isPreferencesButtonVisible() {
        return preferencesButton.isDisplayed();
    }

    public void clickOnPreferencesButton() {
        preferencesButton.click();
    }

    public WebElement getPreferencesPopup() {
        return preferencesPopup;
    }

    public boolean isCountrySelectDropdownOnPreferencesPopupVisible() {
        return countrySelectDropdownOnPreferencesPopup.isDisplayed();
    }

    public boolean isCurrencySelectDropdownOnPreferencesPopupVisible() {
        return currencySelectDropDownOnPreferencesPopup.isDisplayed();
    }

    public boolean isUpdatePreferencesButtonOnPreferencesPopupVisible() {
        return updatePreferencesButtonOnPreferencesPopup.isDisplayed();
    }

    public boolean isHelpAndFAQMenuButtonVisible() {
        return helpAndFAQMenuButton.isDisplayed();
    }

    public void clickOnHelpAndFAQMenuButton() {
        helpAndFAQMenuButton.click();
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }


}
