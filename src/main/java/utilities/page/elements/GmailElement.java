package utilities.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GmailElement {
    private static WebElement sfelement = null;

    private static WebElement gmUserName(WebDriver driver){
        sfelement = driver.findElement(By.id("identifierId"));
        return sfelement;
    }
    public static void fillGmUserName(WebDriver driver, String gmUser){
        sfelement = gmUserName(driver);
        sfelement.sendKeys(gmUser);
    }
    public static WebElement gmBtnNext(WebDriver driver){
        sfelement = driver.findElement(By.id("identifierNext"));
        return sfelement;
    }

    private static WebElement gmUserPassword(WebDriver driver){
        sfelement = driver.findElement(By.name("password"));
        return sfelement;
    }
    public static void fillGmPassword(WebDriver driver, String gmPassword){
        sfelement = gmUserPassword(driver);
        sfelement.sendKeys(gmPassword);
    }
    public static WebElement gmBtnPassNext(WebDriver driver){
        sfelement = driver.findElement(By.id("passwordNext"));
        return sfelement;
    }
    public static WebElement searchOption(WebDriver driver){
        sfelement = driver.findElement(By.linkText("Show search options"));
        //sfelement = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/font[1]/a"));
        return sfelement;
    }
    private static WebElement gmSubject(WebDriver driver){
        //sfelement = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[1]/tbody/tr[3]/td[2]/input"));
        sfelement = driver.findElement(By.name("as_subj"));

        return sfelement;
    }
    public static void fillSubject(WebDriver driver, String subject) {
        sfelement = gmSubject(driver);
        sfelement.sendKeys(subject);
    }
    public static WebElement btnSearchEmail(WebDriver driver){
        sfelement = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr/td/input[1]"));
        return sfelement;
    }
    private static WebElement gmsearchBy(WebDriver driver){
        sfelement = driver.findElement(By.name("as_subset"));

        return sfelement;
    }
    public static void selectSearchBy(WebDriver driver, String searchBy) {
        sfelement = gmsearchBy(driver);
        Select sel = new Select(sfelement);
        sel.selectByVisibleText(searchBy);
    }
    public static WebElement openUnreadEmail(WebDriver driver){
        sfelement = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/table[2]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/a/span/b"));
        return sfelement;
    }
    public static WebElement btnVerifyAccount(WebDriver driver){
        sfelement = driver.findElement(By.linkText("Verify Account"));
        return sfelement;
    }
    public static WebElement gmClassicMode(WebDriver driver){
        sfelement = driver.findElement(By.xpath("as_subset"));
        return sfelement;
}
    public static WebElement classicMode(WebDriver driver){
        sfelement = driver.findElement(By.xpath("//*[@id=\"maia-main\"]/form/p/input"));
        return sfelement;
    }

}
