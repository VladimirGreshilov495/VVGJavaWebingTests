package core.pages.web;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WebGroupsPage extends BasePage{

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
