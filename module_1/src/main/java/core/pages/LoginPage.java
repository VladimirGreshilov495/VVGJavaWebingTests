package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $x("//div[contains(@class,'LoginForm-module__root')]//button[@type='submit']");
    private SelenideElement forgotPasswordLink = $("button.vkuiLink__host");
    private SelenideElement registrationButton = $x("//div[contains(@class,'LoginFormMain-module__bottom')]//button[@type='button']");
    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $(" [data-l='t,vkc'] ");
    private SelenideElement googleButton = $(" [data-l='t,google'] ");
    private SelenideElement mailRuButton = $(" [data-l='t,mailru'] ");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $x("//span[contains(@class,'LoginForm-module__error')]");

    //Локатор для перехода к восстановлению
    private SelenideElement goToRecoveryButton = $("a[href*='anonymRecoveryStart']");

{
    verifyPageElements();
}
    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        //googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }



    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorLoginMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем Восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    // Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Google")
    public void loginWithGoogle() {
        googleButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu() {
        mailRuButton.shouldBe(visible).click();
    }
}