import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected final static String BASE_URL = "https://ok.ru";
    protected final static String BASE_LOGIN = "botS23AT14";
    protected final static String BASE_PASSWORD = "autotests2023";
    protected LoginPage loginPage;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

    }

    @BeforeEach
    public void init() {
        setUp();
        loginPage = new LoginPage(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
