package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionsSteps {

    private static final long DEFAULT_TIME_TO_WAIT = 120;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    BagPage bagPage;
    SignInPage signInPage;
    SavedItemsPage savedItemsPage;
    HelpAndFAQPage helpAndFAQPage;

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void userOpensHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.enterTextInSearchField(keyword);
    }

    @When("User clicks \"Search\" button")
    public void userClicksSearchButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getSearchButton());
        homePage.clickOnSearchButton();
    }

    @Then("User checks that \"Nothing matches\" text is visible")
    public void userChecksThatNothingMatchesTextIsVisible() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(searchResultPage.isNothingMatchesTextContainerVisible());
    }

    @And("User clicks on filtering by brand button")
    public void userClicksOnFilteringByBrandButton() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.clickOnFilteringByBrandButton();
    }

    @And("User clicks on \"ASOS 4505\" brand button")
    public void userClicksOnAsos4505BrandButton() {
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, searchResultPage.getFilteringDropdown());
        searchResultPage.clickOnAsos4505BrandFilteringButton();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, searchResultPage.getListOfProductsTitles().get(0));
    }

    @When("User checks that items filtering by {string}")
    public void userChecksThatItemsFilteringByBrand(final String brandName) {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.getActions().pause(Duration.ofSeconds(2)).build().perform();
        assertTrue(searchResultPage.isProductListFiltered(brandName));
    }

    @And("User clicks on first product on search result page")
    public void userClicksOnFirstProductOnSearchResultPage() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.clickOnFirstProductFromList();
    }

    @And("User clicks on size select button")
    public void userClicksOnSizeSelectDropdownButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        productPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        productPage.clickOnSizeSelectDropdownButton();
    }

    @And("User clicks on first available size")
    public void userClicksOnFirstAvailableSize() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        productPage.clickOnFirstAvailableSizeOption();
    }

    @When("User clicks on \"ADD TO CART\" button")
    public void userClicksOnAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        productPage.clickOnAddToBagButton();
    }

    @When("User clicks on \"BAG\" button")
    public void userClicksOnBagButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        productPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, productPage.getFilledBagButton());
        productPage.clickOnFilledBagButton();
    }

    @And("User clicks on \"VIEW BAG\" button on bag dropdown")
    public void userClicksOnViewBagButton() {
        productPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        productPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        productPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, productPage.getMiniBagDropdown());
        productPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, productPage.getViewBagButton());
        productPage.clickOnViewBagButton();
    }

    @Then("User checks that item was added to cart")
    public void userChecksThatItemWasAddedToCart() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(bagPage.isBagItemsHolderVisible());
    }

    @And("User remove item from cart")
    public void userRemoveItemFromCart() {
        bagPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        bagPage.removeItemFromCart();
    }

    @And("User checks that bag title is {string}")
    public void userChecksBagTitle(String expectedTitle) {
        bagPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        bagPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, bagPage.getEmptyBagTitle());
        assertEquals(expectedTitle, bagPage.getEmptyBagTitleText());
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(homePage.isHeaderVisible());
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        assertTrue(homePage.isFooterVisible());
    }

    @And("User checks \"Bag\" button visibility")
    public void userChecksUnfilledBagButtonVisibility() {
        assertTrue(homePage.isUnFilledBagVisible());
    }

    @And("User checks \"Saved items\" button visibility")
    public void userChecksSavedItemsButtonVisibility() {
        assertTrue(homePage.isSavedItemsButtonVisible());
    }

    @And("User checks \"My Account\" button visibility")
    public void userChecksMyAccountButtonVisibility() {
        assertTrue(homePage.isMyAccountButtonVisible());
    }

    @When("User clicks on \"My Account\" button")
    public void userClicksOnMyAccountButton() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getMyAccountDropdown());
        homePage.clickOnMyAccountButton();
    }

    @And("User checks \"Sign In\" button visibility")
    public void userChecksSignInButtonVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getMyAccountDropdown());
        assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User checks \"Join\" button visibility")
    public void userChecksJoinButtonVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getMyAccountDropdown());
        assertTrue(homePage.isJoinButtonVisible());
    }

    @And("User checks \"Preferences\" button visibility")
    public void userChecksPreferencesButtonVisibility() {
        assertTrue(homePage.isPreferencesButtonVisible());
    }

    @And("User clicks on \"Preferences\" button")
    public void userClicksOnPreferencesButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        homePage.clickOnPreferencesButton();
    }

    @Then("User checks country select on preferences popup")
    public void userChecksCountrySelectOnPreferencesPopup() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getPreferencesPopup());
        assertTrue(homePage.isCountrySelectDropdownOnPreferencesPopupVisible());
    }

    @And("User checks currency select on preferences popup")
    public void userChecksCurrencySelectOnPreferencesPopup() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getPreferencesPopup());
        assertTrue(homePage.isCurrencySelectDropdownOnPreferencesPopupVisible());
    }

    @Then("User checks \"Update Preferences\" button visibility")
    public void userChecksUpdatePreferencesButtonVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getPreferencesPopup());
        assertTrue(homePage.isUpdatePreferencesButtonOnPreferencesPopupVisible());
    }

    @When("User clicks on \"Sign In\" button")
    public void userClicksOnSignInButton() {
        homePage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        homePage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, homePage.getMyAccountDropdown());
        homePage.clickOnSignInButton();
    }

    @And("User enter {string} in email field")
    public void userEnterEmailInEmailField(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.enterEmailInEmailField(email);
    }

    @And("User enter {string} in password field")
    public void userEnterPasswordInPasswordField(final String password) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.enterPasswordInPasswordField(password);
    }

    @And("User clicks on \"Sign In\" button on sign in page")
    public void userClicksOnButtonOnSignInPage() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.clickOnSignInButtonOnSingOnPage();
    }

    @Then("User checks that validation error visibility")
    public void userChecksThatValidationErrorVisibility() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(signInPage.isEmailValidationErrorVisible());
    }

    @And("User clicks \"Save for later\" button on first product")
    public void userClicksSaveForLaterButtonOnFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.clickOnSaveForLaterButton();
    }

    @When("User clicks \"Saved Items\" button")
    public void userClicksOnSavedItemsButton() {
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.clickOnSavedItemsButton();
    }

    @And("User clicks on size select dropdown on \"Saved Items\" page")
    public void userClicksOnSizeSelectDropdownOnSavedItemsPage() {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, savedItemsPage.getSelectSizeButton());
        savedItemsPage.clickOnSelectSizeButton();
    }

    @And("User clicks on first available size option on \"Saved Items\" page")
    public void userClicksOnFirstAvailableSizeOptionOnSavedItemsPage() {
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.clickOnSizeOption();
    }

    @And("User clicks on \"Move To Bag\" button")
    public void userClicksOnMoveToBagButton() {
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.clickOnMoveToBagButton();
    }

    @And("User checks \"Help&FAQs\" menu button visibility")
    public void userChecksHelpAndFAQMenuButtonVisibility() {
        assertTrue(homePage.isHelpAndFAQMenuButtonVisible());
    }

    @When("User clicks on \"Help&FAQs\" menu button")
    public void userClicksOnHelpAndFAQMenuButton() {
        homePage.clickOnHelpAndFAQMenuButton();
    }

    @And("User checks help search field visibility")
    public void userChecksHelpSearchFieldVisibility() {
        helpAndFAQPage = pageFactoryManager.getHelpAndFAQPage();
        helpAndFAQPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        helpAndFAQPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(helpAndFAQPage.isHelpSearchFieldVisible());
    }

    @And("User checks FAQ topics visibility")
    public void userChecksFAQTopicsVisibility() {
        assertTrue(helpAndFAQPage.isFaqTopicsContainerVisible());
    }

    @And("User checks popular FAQs container visibility")
    public void userChecksPopularFAQsContainerVisibility() {
        assertTrue(helpAndFAQPage.isPopularFaqContainerVisible());
    }

    @Then("User checks \"CONTACT US NOW\" button visibility")
    public void userChecksContactUsNowButtonVisibility() {
        assertTrue(helpAndFAQPage.isContactUsNowButtonVisible());
    }

    @And("User checks that amount of items in saved items are {string}")
    public void userChecksThatAmountOfItemsInSaved(final String savedItemsCount) {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIME_TO_WAIT);
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, savedItemsPage.getSavedItemsContainer());
        assertEquals(savedItemsCount, savedItemsPage.getSavedItemsCount());
    }

    @And("User remove item from \"Saved Items\"")
    public void userRemoveItemFromSavedItems() {
        savedItemsPage.clickOnRemoveFromSavedItemsButton();
    }
}
