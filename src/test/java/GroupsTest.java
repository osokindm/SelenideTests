import Pages.GroupPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;

public class GroupsTest extends BaseTest{



    @Test
    public void joinGroup() {
        GroupPage page = loginPage
                .authorize(BASE_LOGIN, BASE_PASSWORD)
                .goToGroupPage();
        int oldValue = Integer.parseInt(page.getGroupCounter().text());
        page.joinGroup();
        webdriver().driver().getWebDriver().navigate().refresh();
        page.getGroupCounter().shouldHave(Condition.text(String.valueOf((oldValue + 1))), Duration.ofSeconds(10));
    }

}
