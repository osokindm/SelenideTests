import Pages.MainPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedTest extends BaseTest{

    private final static String TEXT = "new post";

    @Test
    public void newMessages() {
        MainPage page = loginPage.authorize(BASE_LOGIN, BASE_PASSWORD);
        int newMessagesNumber = page.getNewMessagesNumber();
        assertEquals(newMessagesNumber, page
                .clickOnMessages()
                .countNewMessages());
    }

    @Test
    public void newPost() {
        MainPage page = loginPage.authorize(BASE_LOGIN, BASE_PASSWORD);
        page.writeNewPost(TEXT);
        page.getNewNote().shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
