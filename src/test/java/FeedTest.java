import Pages.MainPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedTest extends BaseTest{

    private final static String TEXT = "new post";

    @Test
    public void newMessages() {
        MainPage mainPage = loginPage.authorize(BASE_LOGIN, BASE_PASSWORD);
        int newMessagesNumber = mainPage.getNewMessagesNumber();
        assertEquals(newMessagesNumber, mainPage
                .clickOnMessages()
                .countNewMessages());
    }

    @Test
    public void newPost() {
        MainPage mainPage = loginPage.authorize(BASE_LOGIN, BASE_PASSWORD);
        mainPage.writeNewPost(TEXT);
        mainPage.getNewNote().shouldBe(Condition.visible);
    }
}
