package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.time.Duration;

public class BasePage extends LoadableComponent<BasePage> {

    protected static SelenideElement waitUntilByShowUp(SelenideElement element, String message) {
        return element.shouldBe(Condition.visible.because(message), Duration.ofSeconds(10));
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
