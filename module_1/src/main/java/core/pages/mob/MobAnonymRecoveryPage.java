package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobAnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton =  $x("//div[contains(@class,'content-card') and contains(@class,'registration_step')][.//div[text()='Телефон']]");

    private SelenideElement recoveryByEmailButton =   $x("//div[contains(@class,'content-card') and contains(@class,'registration_step')][.//div[text()='Электронная почта']]");
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
    }


    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {

        recoveryByEmailButton.shouldBe(visible).click();
    }



}
