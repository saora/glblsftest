package test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.ReadPropertiesFile;
import utilities.page.elements.LoginElement;

public class loginOrgSF extends InitializeDriver {
    private ReadPropertiesFile prop = new ReadPropertiesFile();
    @BeforeTest
    public void setUp() throws Exception{
        initializeDriver();
        driver.get(prop.propFile().getProperty("login.url"));
    }
    @Test
    public void loginOrgSF() throws Exception{
        LoginElement.fillUsername(driver, prop.propFile().getProperty("user.email2"));
        LoginElement.fillPassword(driver, prop.propFile().getProperty("new.pass"));
        LoginElement.btnLogin(driver).click();
        //Verify Your Identity
        try{
            if(LoginElement.linkRegPhoneN(driver).isDisplayed());{
                LoginElement.linkRegPhoneN(driver).click();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    @AfterTest
    public void tearDown()throws Exception{
        Thread.sleep(1000);
       // driver.close();
    }
}
