package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile implements AppInterface {
    public Properties propFile()throws IOException {
        Properties propfile = new Properties();
        FileReader readFile = new FileReader(propertiesFile);
        propfile.load(readFile);
        return propfile;
    }
}
