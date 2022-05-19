package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class SearchResultPage extends CommonElements {

    @FindBy(xpath = "//section[contains(@class,'grid-backgroundWrapper__row')]//section[@class='grid-text__container']")
    private WebElement nothingMatchesTextContainer;

    @FindBy(xpath = "//div[@class='_2pwX7b9' and contains(text(),'Brand')]")
    private WebElement filteringByBrandButton;

    @FindBy(xpath = "//div[@class='_2EAcS_V _2H7teJE']")
    private WebElement filteringDropdown;

    @FindBy(xpath = "//div[@class='kx2nDmW' and contains(text(),'ASOS 4505')]")
    private WebElement asos4505BrandFilterButton;

    @FindBy(xpath = "//div[@class='_3J74XsK']//h2")
    private List<WebElement> listOfProductsTitles;

    @FindBy(xpath = "//div[@class='ERlP6Bx']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//button[@class='_2HTnAzH M3dcC1z']")
    private WebElement saveForLaterButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNothingMatchesTextContainerVisible() {
        return nothingMatchesTextContainer.isDisplayed();
    }

    public WebElement getFilteringDropdown() {
        return filteringDropdown;
    }

    public void clickOnFilteringByBrandButton() {
        filteringByBrandButton.click();
    }

    public void clickOnAsos4505BrandFilteringButton() {
        asos4505BrandFilterButton.click();
    }

    public List<WebElement> getListOfProductsTitles() {
        return listOfProductsTitles;
    }

    public void clickOnFirstProductFromList() {
        productsList.get(0).click();
    }

    public boolean isProductListFiltered(String wordToFilterBy) {
        boolean isFiltered;
        for (WebElement element : getListOfProductsTitles()) {
            String textOfElement = element.getText();
            isFiltered = textOfElement.toLowerCase(Locale.ROOT).contains(wordToFilterBy.toLowerCase(Locale.ROOT));
            if (!isFiltered) {
                return false;
            }
        }
        return true;
    }

    public void clickOnSaveForLaterButton() {
        saveForLaterButton.click();
    }
}
