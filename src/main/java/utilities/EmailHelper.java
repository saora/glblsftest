package utilities;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EmailHelper {
    public static void getPassword(String email, String password) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", email, password);

        Folder folder = store.getFolder("Inbox");
        folder.open(Folder.READ_WRITE);

        System.out.println("Total Message:" + folder.getMessageCount());
        System.out.println("Unread Message:" + folder.getUnreadMessageCount());

        Message[] messages = null;
        boolean isMailFound = false;
        Message mailFromProx = null;

        // Search for mail from Prox with Subject = 'Email varification Testcase'
        for (int i = 0; i <= 5; i++) {

            messages = folder.search(new SubjectTerm("Email varification Testcase"), folder.getMessages());
            // Wait for 20 seconds
            if (messages.length == 0) {
                Thread.sleep(20000);
            }
        }

        // Search for unread mail
        // This is to avoid using the mail for which
        // Registration is already done
        for (Message mail : messages) {
            if (!mail.isSet(Flags.Flag.SEEN)) {
                mailFromProx = mail;
                System.out.println("Message Count is: " + mailFromProx.getMessageNumber());
                isMailFound = true;
            }
        }

        // Test fails if no unread mail was found
        if (!isMailFound) {
            throw new Exception("Could not find new mail from iGotThis :-(");

            // Read the content of mail and get password
        } else {
/*            String line;
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromProx.getInputStream()));
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            System.out.println(buffer);
            String result = buffer.toString().substring(buffer.toString().indexOf("is:") + 1,
                    buffer.toString().indexOf("3. Start enjoying an easier life!"));
            String resultxx = result.substring(4, result.length() - 1);

            //Print passsword
            System.out.println(resultxx);

            Properties prop = new Properties();
            OutputStream output = null;

            *//*try {

                output = new FileOutputStream(Constant.Path_UserPassFile);
                // set the properties value in property file
                prop.setProperty("User_Password", resultxx);
                PropsUtils.setProperties().setProperty("User_Password", resultxx);
                // save properties to project root folder
                prop.store(output, null);

            } catch (IOException io) {
                io.printStackTrace();
            }*//*
            System.out.println("Password = " + prop.getProperty("User_Password"));*/







        }
    }
}
