package test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.EmailHelper;

public class SignupTest {
    @Test(priority = 1, testName = "Verify Email", description = "Verify Email and get password")
    public void User_login() throws Exception {
        try {

            EmailHelper.getPassword("salvador.ortuno@globant.com", "540RamxITOPBE");
            // Login_Action.User_login(iTestCaseRow);

        } catch (Exception e) {
            throw (e);
        }
    }
}
