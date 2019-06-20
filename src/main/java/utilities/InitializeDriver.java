package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InitializeDriver {
    public WebDriver driver;
    private static Logger Add_Log = null;
    private ReadPropertiesFile prop = new ReadPropertiesFile();
    private boolean browserAlreadyLoaded = false;
    private String browser;
    private String baseUrl;
    public void initializeDriver()throws IOException {
        Add_Log = Logger.getLogger("rootLogger: ");
        browser = getPropertyBrowser();
        baseUrl = getPropertyUrl();
        if (!browserAlreadyLoaded) {
            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "browser/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            //driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            browserAlreadyLoaded = true;
            Add_Log.info(browser+" Driver instance loaded successfully");
        }
    }
    private String getPropertyBrowser()throws IOException{
        browser = prop.propFile().getProperty("nav.name");
        Add_Log.info(browser + " browser selected");
        return browser;
    }
    private String getPropertyUrl()throws IOException{
        baseUrl = prop.propFile().getProperty("base.url");
        Add_Log.info(baseUrl+ " URL loaded..");
        return baseUrl;
    }
    protected void closeBrowser()throws Exception{
        Thread.sleep(4000);
        driver.quit();
    }
}
