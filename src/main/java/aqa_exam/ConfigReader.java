package aqa_exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(new File("src/main/resources/conf.prop").getAbsoluteFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProp(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        getProp("trello_key");
    }
}
