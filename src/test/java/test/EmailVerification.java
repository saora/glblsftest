package test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.ReadPropertiesFile;
import utilities.page.elements.ChangePassElement;
import utilities.page.elements.GmailElement;

public class EmailVerification extends InitializeDriver {
    private String fileProp;
    private ReadPropertiesFile prop = new ReadPropertiesFile();

@BeforeTest
    private String getGmailUrl()throws IOException {
    fileProp = prop.propFile().getProperty("gmail.url");
        return fileProp;
    }


    @Test
    public  void test1 ()throws Exception {
        initializeDriver();
        getGmailUrl();
        driver.get(fileProp);
// gmail login
        GmailElement.fillGmUserName(driver, fileProp = prop.propFile().getProperty("gmail.user"));
        GmailElement.gmBtnNext(driver).click();
        Thread.sleep(1000);
        GmailElement.fillGmPassword(driver, fileProp = prop.propFile().getProperty("gmail.pass"));
        GmailElement.gmBtnPassNext(driver).click();
        try {
            WebElement el = GmailElement.classicMode(driver);
                    //driver.findElement(By.xpath("//*[@id=\"maia-main\"]/form/p/input"));
            if (el.isDisplayed()) {
                el.click();
            }
        }catch (Exception e){
            System.out.println("no se encontro el elemento");
        }

            //filter email
            GmailElement.searchOption(driver).click();
            GmailElement.fillSubject(driver, "Welcome to Salesforce: Verify your account");
            GmailElement.selectSearchBy(driver, "Unread Mail");
            GmailElement.btnSearchEmail(driver).click();
            //Open email
            GmailElement.openUnreadEmail(driver).click();
            GmailElement.btnVerifyAccount(driver).click();
            //Change Password
            String parentHandle = driver.getWindowHandle();
            System.out.println(parentHandle);
            //Get all handles
            Set<String> handles = driver.getWindowHandles();
            //Switch between handles
            for (String handle : handles) {
                System.out.println(handle);
                if (!handle.equals(parentHandle)) {
                    driver.switchTo().window(handle);
                    Thread.sleep(3000);
                    ChangePassElement.fillNewPass(driver,fileProp = prop.propFile().getProperty("new.pass"));
                    ChangePassElement.fillConPass(driver,fileProp = prop.propFile().getProperty("conf.pass"));
                    ChangePassElement.fillAnswer(driver,fileProp = prop.propFile().getProperty("answ.text"));
                    if (ChangePassElement.btnPass(driver).isEnabled()) {
                        ChangePassElement.btnPass(driver).click();
                    }
                    Thread.sleep(3000);
                    driver.close();
                    break;
                }
            }
        }
    }



