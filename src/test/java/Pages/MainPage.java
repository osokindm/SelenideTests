package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());
    private static final SelenideElement NAVIGATION_BLOCK = $x("//*[@id=\"hook_Block_Navigation\"]");
    private static final SelenideElement MESSAGE_BUTTON = $x("//*[@id=\"msg_toolbar_button\"]/div[1]");
    private static final SelenideElement NEW_MESSAGES_COUNTER = $x("//*[@id=\"counter_ToolbarMessages\"]//*[@class=\"counterText\"]");
    private static final SelenideElement NOTE_FIELD = $x("//*[@class=\"pf-head_itx_a\"]");
    private static final SelenideElement NOTE_FIELD_LAYER = $x("//*[@class=\"media-layer_c js-mlr-block\"]");
    private static final SelenideElement NOTE_FIELD_EDIT_TEXT = $x("//*[@class=\"posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler\"]");
    private static final ElementsCollection GROUP_BUTTON = $$x("(//*[@class=\"nav-side_i  __with-ic __with-new-icons\"])");
    private static final SelenideElement PHOTO_BUTTON = $x("(//*[@hrefattrs=\"st.cmd=userPhotos&st._aid=NavSideMenu_userPhotos\"])");
    private static final SelenideElement SHARE_BUTTON = $x("//*[@class=\"posting_submit button-pro\"]");
    private static final SelenideElement NEW_NOTE = $x("//*[@class=\"media-text_a\"]");
    private static final String NOTIFICATION_BUBBLE = "//*[@id=\"msg_layer\"]//msg-chat-notification-bubble";


    public MainPage clickOnMessages() {
        waitUntilByShowUp(MESSAGE_BUTTON, null)
                .click();
        return this;
    }

    public GroupPage goToGroupPage() {
        GROUP_BUTTON.get(3).click();
        return new GroupPage();
    }

    public PhotoPage goToPhotoPage() {
        PHOTO_BUTTON.click();
        return new PhotoPage();
    }

    public int getNewMessagesNumber() {
        String counter = NEW_MESSAGES_COUNTER.text();
        if (counter.isEmpty()) {
            counter = "0";
        }
        return Integer.parseInt(counter);
    }

    public int countNewMessages() {
        return $$x(NOTIFICATION_BUBBLE).size();
    }

    public void writeNewPost(String text) {
        NOTE_FIELD.click();
        waitUntilByShowUp(NOTE_FIELD_LAYER, null);
        NOTE_FIELD_EDIT_TEXT.setValue(text);
        SHARE_BUTTON.click();
    }

    public SelenideElement getNewNote() {
        return NEW_NOTE;
    }

    @Override
    protected void isLoaded() throws Error {
        NAVIGATION_BLOCK.shouldBe(Condition.visible.because("Main page did not load properly"));
        LOGGER.info("Pages.MainPage validation succeeded");
    }
}
