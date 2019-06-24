package test;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.ReadPropertiesFile;
import utilities.page.elements.PageSignUpElement;
import java.io.IOException;

public class CreateNewOrg extends InitializeDriver {
    private String fileProp;
    private ReadPropertiesFile prop = new ReadPropertiesFile();
    @BeforeTest
    public String getPropertyUrl()throws IOException {
        fileProp = prop.propFile().getProperty("base.url");
        return fileProp;
    }
    @Test
    public void createOrg()throws Exception{
        initializeDriver();
        getPropertyUrl();
        driver.get(fileProp);
        PageSignUpElement.fillOrgFirstName(driver, fileProp = prop.propFile().getProperty("user.name"));
        PageSignUpElement.fillOrgLastName(driver, fileProp = prop.propFile().getProperty("last.name"));
        PageSignUpElement.fillOrgEmail(driver, fileProp = prop.propFile().getProperty("user.email"));
        PageSignUpElement.selectJobRole(driver, fileProp = prop.propFile().getProperty("job.role"));
        PageSignUpElement.fillCompanyName(driver, fileProp = prop.propFile().getProperty("company.name"));
        PageSignUpElement.selectCountry(driver, fileProp = prop.propFile().getProperty("country.name"));
        PageSignUpElement.fillPostalCode(driver, fileProp = prop.propFile().getProperty("postal.code"));
        PageSignUpElement.fillUserName(driver, fileProp= prop.propFile().getProperty("user.email2"));
        PageSignUpElement.selectCheckBox(driver);
        PageSignUpElement.submitButton(driver).click();
        Thread.sleep(3000);
        EmailVerification openEmail = new EmailVerification();
        openEmail.test1();
    }
    @AfterTest
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}
