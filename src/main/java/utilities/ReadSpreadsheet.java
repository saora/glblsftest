package utilities;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.services.sheets.v4.Sheets;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.page.elements.PageSignUpElement;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
public class ReadSpreadsheet extends InitializeDriver{
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    public static Credential authorize() throws IOException {
// Load client secrets.
        InputStream in = ReadSpreadsheet.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
// Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
    }
    public void getOrgData()  throws Exception{
        initializeDriver();
        //driver.get("https://developer.salesforce.com/signup");
// Build a new authorized API client service.
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "New Org Test Data!A2:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                driver.get("https://developer.salesforce.com/signup");
// Print columns A and E, which correspond to indices 0 and 4.
                PageSignUpElement.fillOrgFirstName(driver,String.valueOf(row.get(0)));
                PageSignUpElement.fillOrgLastName(driver, String.valueOf(row.get(1)));
                PageSignUpElement.fillOrgEmail(driver, String.valueOf(row.get(2)));
                PageSignUpElement.selectJobRole(driver, String.valueOf(row.get(3)));
                PageSignUpElement.fillCompanyName(driver, String.valueOf(row.get(4)));
                PageSignUpElement.selectCountry(driver, String.valueOf(row.get(5)));
                PageSignUpElement.fillPostalCode(driver, String.valueOf(row.get(6)));
                PageSignUpElement.fillUserName(driver, String.valueOf(row.get(7)));
                try{
                if (PageSignUpElement.selectCheckBox(driver)!=null){
                    PageSignUpElement.selectCheckBox(driver).click();
                }
                else
                {
                    System.out.println("No se encontro elemento");
                }}catch(Exception e){
                    System.out.println(e);
                }
                PageSignUpElement.submitButton(driver).click();
                Thread.sleep(6000);
                driver.navigate().refresh();
            }
        }
    }
    }

