package utilities.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageSignUpElement {
    private static WebElement sfelement = null;

    private static WebElement orgSetUp(WebDriver driver){
        sfelement = driver.findElement(By.id("first_name"));
        return sfelement;
    }
    public static void fillOrgFirstName(WebDriver driver, String fname){
        sfelement = orgSetUp(driver);
        sfelement.clear();
        sfelement.sendKeys(fname);
    }

    private static WebElement orgSetUpLN(WebDriver driver){
        sfelement = driver.findElement(By.name("user[last_name]"));
        return sfelement;
    }
    public static void fillOrgLastName(WebDriver driver, String lname){
        sfelement = orgSetUpLN(driver);
        sfelement.clear();
        sfelement.sendKeys(lname);
    }

    private static WebElement orgSetUpEmail(WebDriver driver){
        sfelement = driver.findElement(By.id("email"));
        return sfelement;
    }
    public static void fillOrgEmail(WebDriver driver, String email){
        sfelement = orgSetUpEmail(driver);
        sfelement.clear();
        sfelement.sendKeys(email);
    }
    private static WebElement jobRole(WebDriver driver){
        sfelement = driver.findElement(By.id("job_role"));
        return sfelement;
    }
    public static void selectJobRole(WebDriver driver, String jrole){
        sfelement = jobRole(driver);
        Select sJobRole = new Select(sfelement);
        sJobRole.selectByVisibleText(jrole);
    }

    private static WebElement companyName(WebDriver driver){
        sfelement = driver.findElement(By.id("company"));
        return sfelement;
    }
    public static void fillCompanyName(WebDriver driver, String company){
        sfelement = companyName(driver);
        sfelement.clear();
        sfelement.sendKeys(company);
    }
    private static WebElement orgCountry(WebDriver driver){
        sfelement = driver.findElement(By.id("country"));
        return sfelement;
    }
    public static void selectCountry(WebDriver driver, String seCountry){
        sfelement = orgCountry(driver);
        Select sCountry = new Select(sfelement);
        sCountry.selectByVisibleText(seCountry);
    }
    private static WebElement pCode(WebDriver driver){
        sfelement = driver.findElement(By.id("postal_code"));
        return sfelement;
    }
    public static void fillPostalCode(WebDriver driver, String postalCode){
        sfelement = pCode(driver);
        sfelement.clear();
        sfelement.sendKeys(postalCode);
    }
    private static WebElement userName(WebDriver driver){
        sfelement = driver.findElement(By.id("username"));
        return sfelement;
    }
    public static void fillUserName(WebDriver driver, String uName){
        sfelement = userName(driver);
        sfelement.clear();
        sfelement.sendKeys(uName);
    }
    public static  WebElement selectCheckBox(WebDriver driver){
        sfelement = driver.findElement(By.id("eula"));
        return sfelement;
    }
    public static WebElement submitButton(WebDriver driver){
        sfelement = driver.findElement(By.id("submit_btn"));
        return sfelement;
    }
}
