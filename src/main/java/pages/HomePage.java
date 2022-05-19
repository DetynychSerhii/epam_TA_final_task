package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends CommonElements {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
}
