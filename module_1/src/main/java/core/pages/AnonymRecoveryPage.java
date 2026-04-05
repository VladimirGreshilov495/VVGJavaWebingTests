package core.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $x("//a[@data-l='t,phone']");
    // Кнопка "Почта"
    private SelenideElement recoveryByEmailButton = $x("//a[@data-l='t,email']");
    // Кнопка "Обратиться в службу поддержки"
    private SelenideElement goToSupportButton = $("a.ext-registration_f-support-link");

    private SelenideElement supportChatWindow = $x("//div[contains(@class, 'support-chat__kmsu6')]");

    private SelenideElement exitChatButton = $x("//button[contains(@class, 'button__tndfc button-icon__tndfc')]");

    private SelenideElement approveExitChatButton = $x("//span[contains(@class, 'button-core__0ej09 __size-m__0ej09 __wide__0ej09')]");

    {
        verifyPageElements();
    }



    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }
    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через поддержку")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Проверяем что чат с поддержкой виден пользователю")
    public void supportChat() {
        supportChatWindow.shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Нажимаем на крестик закрыть окно чата с поддержкой")
    public void exitChat() {
        exitChatButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку 'Да'")
    public void approveExitChat() {
        approveExitChatButton.shouldBe(visible).click();
    }


}
