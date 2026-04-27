package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;



public class MobStartPage extends BasePage {
    private SelenideElement enterLoginButton = $("[name='loginButton']");
    {
        verifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        enterLoginButton.shouldBe(visible);
    }

    @Step("Переходим на страницу авторизации")
    public void enterPage() {
        enterLoginButton.shouldBe(visible).click();
    }
}
