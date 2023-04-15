package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage extends LoadableComponent<BasePage> {

    protected static SelenideElement waitUntilByShowUp(SelenideElement element, String message) {
        return element.shouldBe(Condition.visible.because(message));
    }

    protected BasePage() {
        isLoaded();
    }

    @Override
    protected void load() {

    }

}
