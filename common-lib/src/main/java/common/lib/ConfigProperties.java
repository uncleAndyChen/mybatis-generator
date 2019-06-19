package common.lib;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

/**
 * 引用的项目，对应resources目录下需要有一个配置文件：config.properties
 * 获取配置信息时，只需要调用 getValue 方法，参数是配置的 key
 *
 * @author AndyChen
 * @since 2018-12-11
 */
public class ConfigProperties {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = ConfigProperties.class.getResourceAsStream("/config.properties");
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
