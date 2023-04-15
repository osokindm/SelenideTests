package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации сайта Одноклассники
 */
public class LoginPage extends BasePage {

    private static final  String BASE_URL = "https://ok.ru";
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());
    private static final SelenideElement FIELD_EMAIL = $x("//*[@id='field_email']");
    private static final SelenideElement LOGIN_FIELD = $x("//input[@name='st.email']");
    private static final SelenideElement PASSWORD_FIELD = $x("//input[@name='st.password']");
    private static final SelenideElement SUBMIT = $x("//input[@type='submit']");
    private static final SelenideElement LOGIN_ERROR_FIELD = $x("//*/form/div[3]/div");
    private static final SelenideElement LOGIN_TEXT = $x("//*[@class='form_i  anonym_login_field']");


    public MainPage authorize(String login, String password) {
        LOGIN_FIELD
                .shouldBe(Condition.visible)
                .setValue(login)
                .shouldBe(Condition.value(login));
        PASSWORD_FIELD
                .shouldBe(Condition.visible)
                .setValue(password)
                .shouldBe(Condition.value(password));
        SUBMIT.click();
        return new MainPage();
    }

    public SelenideElement getLoginErrorField() {
        return LOGIN_ERROR_FIELD;
    }


    public SelenideElement getLoginText() {
        return LOGIN_TEXT;
    }

    @Override
    protected void load() {
        Selenide.open(BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        load();
        waitUntilByShowUp(FIELD_EMAIL, null);
        LOGGER.info("Pages.MainPage validation succeeded");
    }
}
