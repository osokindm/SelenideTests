package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GroupPage extends BasePage{

    private final SelenideElement joinGroupButton = $x("(//*[@class=\"group-join js-groupJoinButton __inline __small\"])[1]");
    private final SelenideElement groupCounter = $x("(//*[@class=\"portlet_h_count\"])");
    public SelenideElement getGroupCounter() {
        return groupCounter;
    }



    public void joinGroup() {
        waitUntilByShowUp(joinGroupButton, "waiting for groups to load");
        joinGroupButton.click();
    }

}
