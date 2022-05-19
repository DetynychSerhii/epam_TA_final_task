package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends CommonElements {

    @FindBy(xpath = "//select[@id='main-size-select-0']")
    private WebElement sizeSelectDropdownButton;

    @FindBy(xpath = "//select[@id='main-size-select-0']//option")
    private List<WebElement> sizeOptionList;

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToBagButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSizeSelectDropdownButton() {
        sizeSelectDropdownButton.click();
    }

    public void clickOnFirstAvailableSizeOption() {
        sizeOptionList.get(1).click();
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

}
