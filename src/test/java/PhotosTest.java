import Pages.PhotoPage;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotosTest extends BaseTest {

    private final static String BASE_NAME = "new album";


    @Test
    public void createAlbum() {
        PhotoPage page = loginPage
                .authorize(BASE_LOGIN, BASE_PASSWORD)
                .goToPhotoPage();
        String albumName = BASE_NAME + (new Random()).nextInt(1000);
        page.createAlbum(albumName);
        page.getPhotoButton().click();
        String name = page.getAlbumName();
        assertEquals(albumName, name);
    }

    @Test
    public void deleteAlbum() {
        PhotoPage page = loginPage
                .authorize(BASE_LOGIN, BASE_PASSWORD)
                .goToPhotoPage();
        String name = page.deleteLastAlbum();
        assertEquals(0, $$x("(//*[@title=\"" + name + "\"])").size());

    }
}
