package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends CommonElements {

    @FindBy(xpath = "//div[@class='bag-contents-wrapper']")
    private WebElement bagItemsHolder;

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeFromCartButtons;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement emptyBagTitle;

    public BagPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBagItemsHolderVisible() {
        return bagItemsHolder.isDisplayed();
    }

    public void removeItemFromCart() {
        removeFromCartButtons.click();
    }

    public WebElement getEmptyBagTitle() {
        return emptyBagTitle;
    }

    public String getEmptyBagTitleText() {
        return emptyBagTitle.getText();
    }


}
