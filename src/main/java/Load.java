
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Load {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream resAsStream = TestMaven.class.getClassLoader()
        .getResourceAsStream("config.properties")) {
            prop.load(Objects.requireNonNull(resAsStream));
        } catch (IOException e) {
            System.out.println("Unable to load properties file: " + "config.properties");
        }

        System.out.println(prop.get("props.local.hello"));
        System.out.println(prop.get("props.mvn.hello"));
    }
}
