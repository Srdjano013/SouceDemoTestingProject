package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);

    }

    By headerTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By allItemsBy = By.xpath("//*[@id='inventory_sidebar_link']");
    By aboutItemsBy = By.xpath("//*[@id='about_sidebar_link']");
    By logoutItemsBy = By.xpath("//*[@id='logout_sidebar_link']");

    
    public HomePage verifySuccessfulLogin (String expectedText) {
        String pageTitle = readText(headerTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }
    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actualNumberOfProducts = locateElements(numberOfItemsBy).size();
        assertInteegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public HomePage openMenu(){
        click(menuButtonBy);
        return this;
    }

    public HomePage validateMenuItemsTitles (String expectedText1, String expectedText2, String expectedText3) {
        String allItmesTitle = readText(allItemsBy);
        assertStringEquals(allItmesTitle, expectedText1);

        String aboutTitle = readText(aboutItemsBy);
        assertStringEquals(aboutTitle, expectedText2);
        
        String logoutTitle = readText(logoutItemsBy);
        assertStringEquals(logoutTitle, expectedText3);

        return this;
    }
}
