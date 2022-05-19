package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    private final WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

    public BagPage getBagPage() {
        return new BagPage(getDriver());
    }

    public SignInPage getSignInPage() {
        return new SignInPage(getDriver());
    }

    public SavedItemsPage getSavedItemsPage() {
        return new SavedItemsPage(getDriver());
    }

    public HelpAndFAQPage getHelpAndFAQPage() {
        return new HelpAndFAQPage(getDriver());
    }
}
