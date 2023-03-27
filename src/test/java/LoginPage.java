import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации сайта Одноклассники
 */
public class LoginPage extends LoadablePage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());
    private final SelenideElement loginField = $x("//input[@name='st.email']");
    private final SelenideElement passwordField = $x("//input[@name='st.password']");
    private final SelenideElement submit = $x("//input[@type='submit']");
    private final SelenideElement loginErrorField = $x("//*/form/div[3]/div");
    private final SelenideElement navigationBlock = $x("//*[@id=\"hook_Block_Navigation\"]");
    private final SelenideElement loginText = $x("//*[@class='form_i  anonym_login_field']");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    public void authorize(String login, String password) {
        loginField.setValue(login).shouldBe(Condition.value(login));
        passwordField.setValue(password).shouldBe(Condition.value(password));
        submit.click();
    }

    @Override
    public void checkPage() {
        navigationBlock.shouldBe(Condition.visible.because("Main page did not load properly"));
        LOGGER.info("MainPage validation succeeded");
    }

    public SelenideElement getLoginErrorField() {
        return loginErrorField;
    }


    public SelenideElement getLoginText() {
        return loginText;
    }

}
