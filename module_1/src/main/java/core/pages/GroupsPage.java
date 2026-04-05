package core.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage extends BasePage{

    private SelenideElement menuGroupsButton = $x("//a[@href='/groups']");;
    /*
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость кнопке 'Группы'")
    private void verifyPageElements() {
        menuGroupsButton.scrollTo().shouldBe(visible, Duration.ofSeconds(3));
    }

    @Step("Клик по кнопке 'Группы'")
    public void goToGroups() {
        menuGroupsButton.scrollTo().shouldBe(visible).click();
    }
*/

}
