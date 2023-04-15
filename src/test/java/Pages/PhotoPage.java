package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PhotoPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());
    private static final SelenideElement PHOTO_BUTTON = $x("(//*[@hrefattrs=\"st.cmd=userPhotos&st._aid=NavSideMenu_userPhotos\"])");
    private static final SelenideElement CREATE_ALBUM_BUTTON = $x("(//*[@class=\"button-pro __sec __small\"])");
    private static final SelenideElement ALBUM_NAME_EDIT_TEXT = $x("(//*[@class=\"text-field_editor\"])");
    private static final SelenideElement CONFIRM_BUTTON = $x("(//*[@class=\"modal_buttons_yes button-pro form-actions_yes\"])");
    private static final ElementsCollection ALBUM_OPTIONS_BUTTON = $$x("(//*[@class=\"action-btn__u3693\"])");
    private static final SelenideElement EDIT_BUTTON = $x("(//*[@class=\"menu-item__qx66s\"])");
    private static final SelenideElement DELETE_BUTTON = $x("(//*[@class=\"button-pro __sec __small\"])");
    private static final String ALBUM_TITLES = "(//*[@class=\"title__x4tyv\"])";

    public void createAlbum(String text) {
        PHOTO_BUTTON.shouldBe(Condition.visible).click();
        CREATE_ALBUM_BUTTON.shouldBe(Condition.visible).click();
        ALBUM_NAME_EDIT_TEXT.shouldBe(Condition.visible).setValue(text);
        CONFIRM_BUTTON.shouldBe(Condition.visible).click();
    }

    public String getAlbumName() {
        waitUntilByShowUp($$x(ALBUM_TITLES).get(1), null);
        return $$x(ALBUM_TITLES)
                .get(1)
                .getAttribute("title");
    }

    public String deleteLastAlbum() {
        ALBUM_OPTIONS_BUTTON.get(1).click();
        waitUntilByShowUp(EDIT_BUTTON, null).click();
        String name = ALBUM_NAME_EDIT_TEXT.text();
        waitUntilByShowUp(DELETE_BUTTON, null).click();
        waitUntilByShowUp(CONFIRM_BUTTON, null).click();
        return name;
    }

    public SelenideElement getPhotoButton() {
        return PHOTO_BUTTON;
    }


    @Override
    protected void isLoaded() throws Error {
        LOGGER.info("Pages.PhotoPage validation succeeded");
    }
}
