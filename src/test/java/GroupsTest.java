import Pages.GroupPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class GroupsTest extends BaseTest {


    @Test
    public void joinGroup() {
        GroupPage groupPage = loginPage
                .authorize(BASE_LOGIN, BASE_PASSWORD)
                .goToGroupPage();
        int oldValue = Integer.parseInt(groupPage.getGroupCounter().text());
        groupPage.joinGroup();
        Selenide.refresh();
//        groupPage = new LoginPage()
//                .authorize(BASE_LOGIN, BASE_PASSWORD).goToGroupPage();

        groupPage.getGroupCounter().shouldHave(Condition.text(String.valueOf((oldValue + 1))));
    }

}
