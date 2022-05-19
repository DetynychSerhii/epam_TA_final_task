package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpAndFAQPage extends CommonElements {

    @FindBy(xpath = "//div[@class='Hero_searchBar']//input[@name='q']")
    private WebElement helpSearchField;

    @FindBy(xpath = "//div[@class='Homepage_helpTopicsOuterWrapper']")
    private WebElement faqTopicsContainer;

    @FindBy(xpath = "//div[@class='Card_card Card_container']")
    private WebElement popularFaqContainer;

    @FindBy(xpath = "//a[contains(@class,'Button_white undefined')]")
    private WebElement contactUsNowButton;

    public HelpAndFAQPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHelpSearchFieldVisible() {
        return helpSearchField.isDisplayed();
    }

    public boolean isFaqTopicsContainerVisible() {
        return faqTopicsContainer.isDisplayed();
    }

    public boolean isPopularFaqContainerVisible() {
        return popularFaqContainer.isDisplayed();
    }

    public boolean isContactUsNowButtonVisible() {
        return contactUsNowButton.isDisplayed();
    }
}

