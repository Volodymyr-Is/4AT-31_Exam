package aqa_exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static Properties secretProperties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(new File("src/main/resources/conf.prop").getAbsoluteFile()));

            File secretFile = new File("src/main/resources/secret_conf.prop");
            if (secretFile.exists()) {
                secretProperties.load(new FileInputStream(secretFile.getAbsoluteFile()));
            } else {
                System.err.println("УВАГА: Файл secret_conf.prop не знайдено!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProp(String key){
        return properties.getProperty(key);
    }

    public static String getSecretProp(String key){
        return secretProperties.getProperty(key);
    }
}
