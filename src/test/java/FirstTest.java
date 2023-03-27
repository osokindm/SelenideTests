import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class FirstTest extends BaseTest {

    private final static String BASE_URL = "https://ok.ru";
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String WRONG_PASSWORD = "qwerty";
    private final static String NO_USERNAME_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";

    @Test
    public void rightLogIn() {
        LoginPage page = new LoginPage(BASE_URL);
        page.authorize(LOGIN, PASSWORD);
    }

    @Disabled
    @Test
    public void wrongPassword() {
        LoginPage page = new LoginPage(BASE_URL);
        page.authorize(LOGIN, WRONG_PASSWORD);
        page.getLoginErrorField().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
    }

    @Disabled
    @Test
    public void noPassword() {
        LoginPage page = new LoginPage(BASE_URL);
        page.authorize(LOGIN, "");
        page.getLoginErrorField().shouldHave(Condition.text("Введите пароль"));
    }

    @Disabled
    @Test
    public void noUsername() {
        LoginPage page = new LoginPage(BASE_URL);
        page.authorize("", PASSWORD);
        webdriver().shouldHave(url(NO_USERNAME_URL));
        page.getLoginErrorField().shouldHave(Condition.text("Введите логин"));
    }

    @Disabled
    @Test
    public void checkButton() {
        LoginPage page = new LoginPage(BASE_URL);
        assertThat(page.getLoginText().text(), equalToIgnoringCase("Телефон или адрес эл. почты"));
    }
}
