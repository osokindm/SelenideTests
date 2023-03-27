import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTest extends BaseTest{

    private final static String BASE_URL = "https://ok.ru";
    private final static String LOGIN = "botS23AT14";
    private final static String PASSWORD = "autotests2023";

    public SecondTest() {
        LoginPage page = new LoginPage(BASE_URL);
        page.authorize(LOGIN, PASSWORD);
        page.checkPage();
    }

    @Test
    public void newMessages() {
        MainPage page = new MainPage();
        int newMessagesNumber = page
                .clickOnMessages()
                .waitForNewMessages()
                .countNewMessagesNumber();
        assertEquals(2, newMessagesNumber);
    }


    @Test
    public void newPost() {
        MainPage page = new MainPage();
        page.writeNewPost(LOGIN);
        page.getNewNote().shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Test
    public void joinGroup() {
        MainPage page = new MainPage();
        page.getGroupButton().click();
        int oldValue = Integer.parseInt(page.getGroupCounter().text());
        page.joinGroup();
        webdriver().driver().getWebDriver().navigate().refresh();
        page.getGroupCounter().shouldHave(Condition.text(String.valueOf((oldValue + 1))), Duration.ofSeconds(10));
    }

    @Disabled
    @Test
    public void createAlbum() {
        MainPage page = new MainPage();
        page.getPhotoButton().click();
        page.getShowMoreButton().click();
        int oldValue = page.countAlbumNumber();
        page.createAlbum(LOGIN);
        page.getPhotoButton().click();
        page.getShowMoreButton().click();
        assertEquals(oldValue + 1, page.countAlbumNumber());
    }

    @Disabled
    @Test
    public void deleteAlbum() {

    }

}
