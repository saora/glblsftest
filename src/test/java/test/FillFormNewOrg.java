package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.ReadPropertiesFile;
import utilities.ReadSpreadsheet;
import utilities.page.elements.PageSignUpElement;

public class FillFormNewOrg extends InitializeDriver {
@Test
    public void fillOutFormNewOrg() throws Exception{
    initializeDriver();
    driver.get("https://developer.salesforce.com/signup");

    PageSignUpElement.fillOrgFirstName(driver, "Salvador");
    PageSignUpElement.fillOrgLastName(driver, "Ortuno");
    PageSignUpElement.fillOrgEmail(driver, "glbltest.salesforce@gmail.com");
    PageSignUpElement.selectJobRole(driver,"Administrator");
    PageSignUpElement.fillCompanyName(driver, "Test Company");
    PageSignUpElement.selectCountry(driver, "United States");
    PageSignUpElement.fillPostalCode(driver,"0300");
    PageSignUpElement.fillUserName(driver,"glblautomation02@de.org");
    PageSignUpElement.selectCheckBox(driver);
    PageSignUpElement.submitButton(driver).click();
    }
   @AfterTest
    public void tearDown()throws Exception{
       Thread.sleep(3000);
       driver.quit();
    }
}
