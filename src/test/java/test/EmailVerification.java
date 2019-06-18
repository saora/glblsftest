package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;


public class EmailVerification {
    @Test
    public  void test1 ()throws Exception {

        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sortuno\\IdeaProjects\\LightningSalesforce\\browser\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://accounts.google.com/ServiceLogin?");

// gmail login
        driver.findElement(By.id("identifierId")).sendKeys("salvador.ortuno@globant.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("540RamxITOPBE");
        driver.findElement(By.id("passwordNext")).click();
        driver.findElement(By.className("gb_xe")).click();
        driver.findElement(By.className("gb_k")).click();

/*
// some optional actions for reaching gmail inbox
        driver.findElement(By.xpath("//*[@title='Google apps']")).click();
        driver.findElement(By.id("gb23")).click();
*/
        System.out.println("validando... ");
// now talking un-read email form inbox into a list
      //List<WebElement> unreademeil = driver.findElements(By.xpath("//*[contains(text(),'Email varification Testcase')]"));
       /* WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> inboxEmails = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='zA zE']"))));*/

        List<WebElement> a = driver.findElements(By.xpath("//table/tbody/tr/td[5]/div[@class='yW']"));
        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getText());
            if (a.get(i).getText().equals("Email varification Testcase")) //to click on a specific mail.
            {
                a.get(i).click();
            }
        }




  /*      int size = unreademeil.size();
        System.out.println("Size of the list: "+size);
// real logic starts here
        for (int i = 0; i < size; i++) {
            System.out.println("Size of the list: "+size);
// Mailer name for which i want to check do i have an email in my inbox
            String MyMailer = "Atlassian";
            if (unreademeil.get(i).isDisplayed() == true) {
                // now verify if you have got mail form a specific mailer (Note Un-read mails)
                // for read mails xpath loactor will change but logic will remain same
                if (unreademeil.get(i).getText().equals(MyMailer)) {
                    System.out.println("Yes we have got mail form " + MyMailer);
                    // also you can perform more actions here
                    // like if you want to open email form the mailer
                    break;
                } else {
                    System.out.println("No mail form " + MyMailer);
                }
            }
        }*/

    }
}


