package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavedItemsPage extends CommonElements {

    @FindBy(xpath = "//select[@aria-label='Size']")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//select[@aria-label='Size']/option")
    private List<WebElement> sizeOption;

    @FindBy(xpath = "//button[contains(@class,'toBagButton')]")
    private WebElement moveToBagButton;

    @FindBy(xpath = "//div[@class='customerItemsProductTile_UTepY']")
    private List<WebElement> savedItemsList;

    @FindBy(xpath = "//button[contains(@class,'deleteButton_c9wnw')]")
    private WebElement removeItemFromSavedItemsButton;

    @FindBy(xpath = "//section[@class='productTilesWrapper_LkXSW']")
    private WebElement savedItemsContainer;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSelectSizeButton() {
        return selectSizeButton;
    }

    public void clickOnSelectSizeButton() {
        selectSizeButton.click();
    }

    public void clickOnSizeOption() {
        sizeOption.get(1).click();
    }

    public void clickOnMoveToBagButton() {
        moveToBagButton.click();
    }

    public String getSavedItemsCount() {
        return String.valueOf(savedItemsList.size());
    }

    public void clickOnRemoveFromSavedItemsButton() {
        removeItemFromSavedItemsButton.click();
    }

    public WebElement getSavedItemsContainer() {
        return savedItemsContainer;
    }
}
