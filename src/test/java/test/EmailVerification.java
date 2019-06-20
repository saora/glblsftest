package test;
import org.openqa.selenium.By;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.InitializeDriver;
import utilities.page.elements.GmailElement;

public class EmailVerification extends InitializeDriver{
    @Test
    public  void test1 ()throws Exception {
        initializeDriver();
        driver.get("https://mail.google.com/mail/?ui=html&zy=h");
// gmail login
        GmailElement.fillGmUserName(driver,"glbltest.salesforce@gmail.com");
        GmailElement.gmBtnNext(driver).click();
        Thread.sleep(3000);
        GmailElement.fillGmPassword(driver,"61084n7mex01");
        GmailElement.gmBtnPassNext(driver).click();
        Thread.sleep(3000);
        try {
            WebElement el = driver.findElement(By.xpath("//*[@id=\"maia-main\"]/form/p/input"));
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
                    driver.findElement(By.id("newpassword")).sendKeys("test1234");
                    driver.findElement(By.id("confirmpassword")).sendKeys("test1234");
                    driver.findElement(By.id("answer")).sendKeys("test");
                    if (driver.findElement(By.id("password-button")).isEnabled()) {
                        driver.findElement(By.id("password-button")).click();
                    }
                    Thread.sleep(3000);
                    driver.close();
                    break;
                }
            }
        }
    }



