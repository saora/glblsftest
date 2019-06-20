package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.InitializeDriver;

import java.io.IOException;
import java.util.Set;

public class ChangePassword extends EmailVerification {

public void changePass() throws InterruptedException {
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

