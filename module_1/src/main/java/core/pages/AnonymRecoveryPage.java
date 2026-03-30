package core.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $x("//a[@data-l='t,phone']");
    // Кнопка "Почта"
    private SelenideElement recoveryByEmailButton = $x("//a[@data-l='t,email']");
    // Кнопка "Обратиться в службу поддержки"
    private SelenideElement goToSupportButton = $("a.ext-registration_f-support-link");
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


}
