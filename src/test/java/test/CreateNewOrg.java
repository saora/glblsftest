package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.page.elements.PageSignUpElement;

public class CreateNewOrg extends InitializeDriver {
    @BeforeTest
    public void setUp() throws Exception{
        initializeDriver();
        driver.get("https://developer.salesforce.com/signup");
    }
    @Test
    public void createOrg()throws Exception{
        PageSignUpElement.fillOrgFirstName(driver, "Salvador");
        PageSignUpElement.fillOrgLastName(driver, "Ortuno");
        PageSignUpElement.fillOrgEmail(driver, "salvador.ortuno@globant.com");
        PageSignUpElement.selectJobRole(driver,"Administrator");
        PageSignUpElement.fillCompanyName(driver, "Test Company");
        PageSignUpElement.selectCountry(driver, "United States");
        PageSignUpElement.fillPostalCode(driver,"0300");
        PageSignUpElement.fillUserName(driver,"glblautomationtest33@de.org");
        PageSignUpElement.selectCheckBox(driver,true);
        PageSignUpElement.submitButton(driver).click();

        EmailVerification openEmail = new EmailVerification();
        openEmail.test1();
    }
    @AfterTest
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}
