import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class FirstTest extends BaseTest {

    private final static String BASE_URL = "https://ok.ru";
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String WRONG_PASSWORD = "qwerty";
    private final static String NO_USERNAME_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";
    //private final static String NO_PASSWORD_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.password.empty*";
    //private final static String WRONG_PASSWORD_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.password.wron*/";

    @Test
    public void rightLogIn() {
        MainPage page = new MainPage(BASE_URL);
        page.authorize(LOGIN, PASSWORD);
        page.getMainPageButton().shouldBe(Condition.visible);
    }

    @Test
    public void wrongPassword() {
        MainPage page = new MainPage(BASE_URL);
        page.authorize(LOGIN, WRONG_PASSWORD);
        //webdriver().shouldHave(url(WRONG_PASSWORD_URL));
        page.getLoginErrorField().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
    }

    @Test
    public void noPassword() {
        MainPage page = new MainPage(BASE_URL);
        page.authorize(LOGIN, "");
        //webdriver().shouldHave(url(NO_PASSWORD_URL));
        page.getLoginErrorField().shouldHave(Condition.text("Введите пароль"));
    }

    @Test
    public void noUsername() {
        MainPage page = new MainPage(BASE_URL);
        page.authorize("", PASSWORD);
        webdriver().shouldHave(url(NO_USERNAME_URL));
        page.getLoginErrorField().shouldHave(Condition.text("Введите логин"));
    }
}
