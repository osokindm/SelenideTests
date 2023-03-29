package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class MainPage extends BasePage {
    private final SelenideElement messageButton = $x("//*[@id=\"msg_toolbar_button\"]/div[1]");
    private final SelenideElement newMessagesCounter = $x("//*[@id=\"counter_ToolbarMessages\"]//*[@class=\"counterText\"]");
    private final SelenideElement noteField = $x("//*[@class=\"pf-head_itx_a\"]");
    private final SelenideElement noteFieldLayer = $x("//*[@class=\"media-layer_c js-mlr-block\"]");
    private final SelenideElement noteFieldEditText = $x("//*[@class=\"posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler\"]");
    private final SelenideElement groupButton = $x("(//*[@class=\"nav-side_i  __with-ic __with-new-icons\"])[4]");
    private final SelenideElement photoButton = $x("(//*[@hrefattrs=\"st.cmd=userPhotos&st._aid=NavSideMenu_userPhotos\"])");
    private final SelenideElement shareButton = $x("//*[@class=\"posting_submit button-pro\"]");
    private final SelenideElement newNote = $x("//*[@class=\"media-text_a\"]");


    public MainPage clickOnMessages() {
        waitUntilByShowUp(messageButton, "waiting for message button to load")
                .click();
        return this;
    }

    public GroupPage goToGroupPage() {
        groupButton.click();
        return new GroupPage();
    }

    public PhotoPage goToPhotoPage() {
        photoButton.click();
        return new PhotoPage();
    }

    public int getNewMessagesNumber() {
        String counter = newMessagesCounter.text();
        if (counter.isEmpty()) {
            counter = "0";
        }
        return Integer.parseInt(counter);
    }

    public int countNewMessages() {
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


}
