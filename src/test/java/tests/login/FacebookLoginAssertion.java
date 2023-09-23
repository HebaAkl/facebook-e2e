package tests.login;

import org.testng.Assert;
import pages.login.LoginPage;

import static tests.BaseTest.driver;

public class FacebookLoginAssertion {
    LoginPage loginPage;

    public void assertUserLoginSuccessfully(){
        assertUserIsDirectedToHomePage();
        assertPostTextIsDisplayed();

    }

    public void assertUserIsDirectedToHomePage(){
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getPageURL(), "https://www.facebook.com/home.php");
    }

    public void assertPostTextIsDisplayed(){
        loginPage = new LoginPage(driver);
        loginPage.isTextDisplayed("What's on your mind,");
    }

    public void assertNotExistCredentialsIsDisplayed(){
        loginPage = new LoginPage(driver);
        loginPage.isTextDisplayed("The email address you entered isn't connected to an account. ");
    }
}
