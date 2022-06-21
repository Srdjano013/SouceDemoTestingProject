package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {
    
    public LoginPage loginPage;
    public HomePage homePage;

    int numberOfAllItems = 6;
    String Text1 = "ALL ITEMS";
    String Text2 = "ABOUT";
    String Text3 = "LOGOUT";

    
@Test
    public void CheckNUmberOfItemsOnHomePage(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);  
        
        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.validateNumberOfProducts(numberOfAllItems);
    }
@Test
    public void CheckMenuButtonsTitles(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.openMenu();
        homePage.validateMenuItemsTitles(Text1, Text2, Text3);
    }
}
