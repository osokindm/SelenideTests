import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class MainPage extends LoadablePage {
    private final SelenideElement messageButton = $x("//*[@id=\"msg_toolbar_button\"]/div[1]");
    private final SelenideElement messageButtonNotif = $x("//*[@id='counter_ToolbarMessages']");
    private final SelenideElement closeMessagesButton = $x("//*[@class=\"toolbar-layer_controls_item js-close-layer\"]");
    private final SelenideElement newMessagesNotif = $x("//*[@id=\"msg_layer\"]//msg-chat-notification-bubble");
    private final SelenideElement noteField = $x("//*[@class=\"pf-head_itx_a\"]");
    private final SelenideElement noteFieldLayer = $x("//*[@class=\"media-layer_c js-mlr-block\"]");
    private final SelenideElement noteFieldEditText = $x("//*[@class=\"posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler\"]");
    private final SelenideElement shareButton = $x("//*[@class=\"posting_submit button-pro\"]");
    private final SelenideElement newNote = $x("//*[@class=\"media-text_a\"]");
    private final SelenideElement groupButton = $x("(//*[@class=\"nav-side_i  __with-ic __with-new-icons\"])[4]");
    private final SelenideElement joinGroupButton = $x("(//*[@class=\"group-join js-groupJoinButton __inline __small\"])[1]");
    private final SelenideElement groupCounter = $x("(//*[@class=\"portlet_h_count\"])");
    private final SelenideElement photoButton = $x("(//*[@hrefattrs=\"st.cmd=userPhotos&st._aid=NavSideMenu_userPhotos\"])");
    private final SelenideElement createAlbumButton = $x("(//*[@class=\"button-pro __sec __small\"])");
    private final SelenideElement albumNameEditText = $x("(//*[@class=\"text-field_editor\"])");
    private final SelenideElement confirmButton = $x("(//*[@class=\"modal_buttons_yes button-pro form-actions_yes\"])");
    private final SelenideElement albumList = $x("(//*[@class=\"photo-album-card__cpony __redesign__cpony\"])");
    private final SelenideElement backToAlbumsButton = $x("//*[@id=\"hook_Block_UserAlbumPhotosBlock\"]/div/div[1]/a");
    private final SelenideElement showMoreButton = $x("(//*[@class=\"js-show-more link-show-more link-show-more__photo\"])");


    public static SelenideElement waitUntilByShowUp(SelenideElement element, String message) {
        return element.shouldBe(Condition.visible.because(message), Duration.ofSeconds(10));
    }


    public MainPage clickOnMessages() {
        waitUntilByShowUp(messageButton, "waiting for message button to load")
                .click();
        return this;
    }

    public MainPage waitForNewMessages() {
        waitUntilByShowUp(newMessagesNotif, "waiting for notifications to load");
        return this;
    }

    public int countNewMessagesNumber() {
        return webdriver().driver().getWebDriver()
                .findElements(By.xpath("//*[@id=\"msg_layer\"]//msg-chat-notification-bubble")).size();
    }

    public void writeNewPost(String text) {
        noteField.click();
        waitUntilByShowUp(noteFieldLayer, "waiting for post field to show up");
        noteFieldEditText.setValue(text);
        shareButton.click();
    }

    public SelenideElement getNewNote() {
        return newNote;
    }

    public SelenideElement getGroupButton() {
        return groupButton;
    }

    public SelenideElement getPhotoButton() {
        return photoButton;
    }

    public SelenideElement getGroupCounter() {
        return groupCounter;
    }

    public SelenideElement getShowMoreButton() {
        return showMoreButton;
    }

    public void joinGroup() {
        waitUntilByShowUp(joinGroupButton, "waiting for groups to load");
        joinGroupButton.click();
    }

    public void createAlbum(String text) {
        photoButton.click();
        createAlbumButton.click();
        albumNameEditText.setValue(text);
        confirmButton.click();
    }

    public int countAlbumNumber() {
        return webdriver().driver().getWebDriver()
                .findElements(By.xpath("(//*[@class=\"photo-album-card__cpony __redesign__cpony\"])")).size();
    }
}
