package core.base;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    // Базовый URL для веб-тестов
    protected static String baseUrl;
    @BeforeAll
    public static void setUp() {
        baseUrl = determineBaseUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 10000;
    }
    private static String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFileName = "application-" + environment + ".properties";
        Properties properties = new Properties();
        try (InputStream input = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + configFileName);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to load configuration file: " + configFileName, e);
        }
        return properties.getProperty("baseUrl");
    }
    public String getBaseUrl() {
        return baseUrl;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}

