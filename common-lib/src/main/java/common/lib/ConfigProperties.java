package common.lib;

import sun.nio.cs.Surrogate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = Surrogate.Generator.class.getResourceAsStream("/application.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key, "");
    }
}
