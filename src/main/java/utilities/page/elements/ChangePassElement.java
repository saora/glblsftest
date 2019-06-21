package utilities.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePassElement {
    private static WebElement cpelement = null;

    private static WebElement newPass (WebDriver driver){
        cpelement = driver.findElement(By.id("newpassword"));
        return cpelement;
    }
    public static void fillNewPass(WebDriver driver, String newPass){
        cpelement = newPass(driver);
        cpelement.sendKeys(newPass);
    }
    private static WebElement conPass (WebDriver driver){
        cpelement = driver.findElement(By.id("confirmpassword"));
        return cpelement;
    }
    public static void fillConPass(WebDriver driver, String confirmPass){
        cpelement = conPass(driver);
        cpelement.sendKeys(confirmPass);
    }
    private static WebElement answText (WebDriver driver){
        cpelement = driver.findElement(By.id("answer"));
        return cpelement;
    }
    public static void fillAnswer(WebDriver driver, String answerText){
        cpelement = answText(driver);
        cpelement.sendKeys(answerText);
    }

    public static WebElement btnPass (WebDriver driver){
        cpelement = driver.findElement(By.id("password-button"));
        return cpelement;
    }
}
