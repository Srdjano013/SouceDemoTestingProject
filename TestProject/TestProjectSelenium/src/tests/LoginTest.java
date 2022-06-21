package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    
    public LoginPage loginPage;
    public HomePage homePage;
           String messageError = "Epic sadface: Username and password do not match any user in this service";
           String messageErrorLockedUser = "Epic sadface: Sorry, this user has been locked out.";
           String messageNoUsername = "Epic sadface: Username is required";
           String messageNoPassword = "Epic sadface: Password is required";
           String invalidUsername = "standard_user2";
           String lockedOutUserUsername = "locked_out_user";
           String invalidPassword = "secret_sauce2";
           String noUsername = "";
           String noPassword = "";


    @Test
    public void validLoginTest(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.verifySuccessfulLogin(messageError);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }
    @Test
    public void invalidUsername() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(invalidUsername, validPassword);
        loginPage.verifyUnsuccessfulLogin(messageError);

    }
    @Test
    public void lockedUserLogin() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(lockedOutUserUsername, validPassword);
        loginPage.verifyUnsuccessfulLogin(messageErrorLockedUser);
    }
    @Test
    public void invalidPasswordLogin() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, invalidPassword);
        loginPage.verifyUnsuccessfulLogin(messageError);
    }   
    @Test
    public void noUsernameLogin() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(noUsername, invalidPassword);
        loginPage.verifyUnsuccessfulLogin(messageNoUsername);
    }   
    @Test
    public void noPasswordLogin() {
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, noPassword);
        loginPage.verifyUnsuccessfulLogin(messageNoPassword);
    } 
}
