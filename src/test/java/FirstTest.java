import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FirstTest extends BaseTest {

    private final static String WRONG_PASSWORD = "qwerty";
    private final static String NO_USERNAME_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";
    private final static String ERROR_1 = "Неправильно указан логин и/или пароль";
    public static final String WARNING_PASSWORD = "Введите пароль";
    public static final String WARNING_LOGIN = "Введите логин";
    public static final String PHONE_OR_EMAIL = "Телефон или адрес эл. почты";

    @Test
    public void rightLogIn() {
        assertNotNull(loginPage.authorize(BASE_LOGIN, BASE_PASSWORD));
    }

    @Disabled
    @Test
    public void wrongPassword() {
        loginPage.authorize(BASE_LOGIN, WRONG_PASSWORD);
        assertThat(loginPage.getLoginErrorField().text(), containsString(ERROR_1));
    }

    @Disabled
    @Test
    public void noPassword() {
        loginPage.authorize(BASE_LOGIN, "");
        assertThat(loginPage.getLoginErrorField().text(), containsString(WARNING_PASSWORD));

    }

    @Disabled
    @Test
    public void noUsername() {
        loginPage.authorize("", BASE_PASSWORD);
        webdriver().shouldHave(url(NO_USERNAME_URL));
        assertThat(loginPage.getLoginErrorField().text(), containsString(WARNING_LOGIN));

    }

    @Disabled
    @Test
    public void checkButton() {
        assertThat(loginPage.getLoginText().text(), equalToIgnoringCase(PHONE_OR_EMAIL));
    }
}
