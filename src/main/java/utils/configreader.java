package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configreader {


Properties prop;

public configreader() {

    try {
        prop = new Properties();

        FileInputStream fis = new FileInputStream(
                "src/main/resources/configfiles/config.properties");

        prop.load(fis);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public String getBrowser() {
    return prop.getProperty("browser");
}

public String getUrl() {
    return prop.getProperty("url");
}


}

