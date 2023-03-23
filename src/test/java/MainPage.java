import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации сайта Одноклассники
 */
public class MainPage {

    private final SelenideElement loginField = $x("//input[@name='st.email']");
    private final SelenideElement passwordField = $x("//input[@name='st.password']");
    private final SelenideElement submit = $x("//input[@type='submit']");
    private final SelenideElement loginErrorField = $x("//*/form/div[3]/div");
    private final SelenideElement mainPageButton = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[2]/a");
    private final SelenideElement loginText = $x("//*[@class='form_i  anonym_login_field']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void authorize(String login, String password) {
        loginField.setValue(login).shouldBe(Condition.value(login));
        passwordField.setValue(password).shouldBe(Condition.value(password));
        submit.click();
    }

    public SelenideElement getLoginErrorField() {
        return loginErrorField;
    }

    public SelenideElement getMainPageButton() {
        return mainPageButton;
    }

    public SelenideElement getLoginText() {
        return loginText;
    }

}
