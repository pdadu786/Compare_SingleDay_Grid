package CompareGrids;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
/**
 * Created by praveendadu on 17/07/2017.
 */
public class Readconfig {
    static String str;
        static File file = new File(System.getProperty("user.dir") + "/src/config.properties");
        static FileInputStream fileInput = null;

    public static String returnconfig(String Stringval){
        try {
            fileInput = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(Stringval);
    }
}

