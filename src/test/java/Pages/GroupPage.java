package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GroupPage extends BasePage{

    private static final Logger LOGGER = Logger.getLogger(GroupPage.class.getName());
    private static final ElementsCollection JOIN_GROUP_BUTTON = $$x("(//*[contains(@class, \"group-join js-groupJoinButton\")])");
    private static final SelenideElement GROUP_COUNTER = $x("(//*[@class=\"portlet_h_count\"])");
    public SelenideElement getGroupCounter() {
        return GROUP_COUNTER;
    }



    public void joinGroup() {
        waitUntilByShowUp(JOIN_GROUP_BUTTON.get(0), null);
        JOIN_GROUP_BUTTON.get(0).shouldBe(Condition.visible).click();
    }

    @Override
    protected void isLoaded() throws Error {
        LOGGER.info("Pages.GroupPage validation succeeded");

    }

}
