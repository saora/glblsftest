package utilities.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElement {
    private static WebElement loginelement = null;

    private static WebElement loginUsername(WebDriver driver){
        loginelement = driver.findElement(By.id("username"));
        return loginelement;
    }
    public static void fillUsername(WebDriver driver, String loginUser){
        loginelement = loginUsername(driver);
        loginelement.sendKeys(loginUser);
    }
    private static WebElement loginPassword(WebDriver driver){
        loginelement = driver.findElement(By.id("password"));
        return loginelement;
    }
    public static void fillPassword(WebDriver driver, String loginPass){
        loginelement = loginPassword(driver);
        loginelement.sendKeys(loginPass);
    }

    public static WebElement btnLogin(WebDriver driver){
        loginelement = driver.findElement(By.id("Login"));
        return loginelement;
    }
    private static WebElement verificationCode(WebDriver driver){
        loginelement = driver.findElement(By.id("emc"));
        return loginelement;
    }
    public static void fillVerificationCode(WebDriver driver, String vCode){
        loginelement = loginUsername(driver);
        loginelement.sendKeys(vCode);
    }
    public static WebElement btnVerify(WebDriver driver){
        loginelement = driver.findElement(By.id("save"));
        return loginelement;
    }
}
