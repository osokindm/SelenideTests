package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class PhotoPage extends BasePage {

    private final SelenideElement photoButton = $x("(//*[@hrefattrs=\"st.cmd=userPhotos&st._aid=NavSideMenu_userPhotos\"])");
    private final SelenideElement createAlbumButton = $x("(//*[@class=\"button-pro __sec __small\"])");
    private final SelenideElement albumNameEditText = $x("(//*[@class=\"text-field_editor\"])");
    private final SelenideElement confirmButton = $x("(//*[@class=\"modal_buttons_yes button-pro form-actions_yes\"])");
    private final SelenideElement albumOptionsButton = $x("(//*[@class=\"action-btn__u3693\"])[2]");
    private final SelenideElement editButton = $x("(//*[@class=\"menu-item__qx66s\"])");
    private final SelenideElement deleteButton = $x("(//*[@class=\"button-pro __sec __small\"])");

    public void createAlbum(String text) {
        photoButton.click();
        createAlbumButton.click();
        albumNameEditText.setValue(text);
        confirmButton.click();
    }

    public String getAlbumName() {
        waitUntilByShowUp($x("(//*[@class=\"title__x4tyv\"])[2]"), null);
        return webdriver().driver().getWebDriver()
                .findElement(By.xpath("(//*[@class=\"title__x4tyv\"])[2]"))
                .getAttribute("title");
    }

    public String deleteLastAlbum() {
        albumOptionsButton.click();
        waitUntilByShowUp(editButton, null).click();
        String name = albumNameEditText.text();
        waitUntilByShowUp(deleteButton, null).click();
        waitUntilByShowUp(confirmButton, null).click();
        return name;
    }

    public SelenideElement getPhotoButton() {
        return photoButton;
    }

}
