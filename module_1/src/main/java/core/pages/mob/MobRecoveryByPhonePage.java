package core.pages.mob;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobRecoveryByPhonePage extends BasePage {

    //Локатор для кнопки выбора страны
    private SelenideElement countryDropdown = $x("//a[@id='countryName']");

    //Локатор для поля ввода номера телефона
    private SelenideElement phoneInputField = $("[name='rfr.phone']");

    //Локатор для нажатия по кнопке "Получить код"
    private SelenideElement goToGetCodeButton = $("input[id='getCode']");

    //Локатор прокерки телефона
    private SelenideElement errorPhoneNumber = $("label[class='field_error-descr' ]");

    {
        verifyPageElements();
    }
    @Step("Проверяем видимость всех элементов на странице восстановления через телефон")
    private void verifyPageElements() {
        countryDropdown.shouldBe(visible);
        phoneInputField.shouldBe(visible);
        goToGetCodeButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $x(
                String.format("//div[@class='reg_choose_country'][text()='%s']", countryName)
        );
        // Скроллим к элементу чтобы вывести из-под тулбара
        countryItem.scrollIntoView("{block: 'center'}");
        // Берём код до клика
        String countryCode = countryItem
                .parent()
                .find(".reg_choose_prefix")
                .text();
        // JS-клик обходит перекрытие
        Selenide.executeJavaScript("arguments[0].click()", countryItem);
        return countryCode;
    }

    @Step("Вводим номер телефона {phoneNumber}")
    public String selectPhoneNumber(String phoneNumber) {
        phoneInputField.shouldBe(visible).click();
        phoneInputField.shouldBe(visible).setValue(phoneNumber);
        goToGetCodeButton.shouldBe(visible).click();
        return errorPhoneNumber.shouldBe(visible).getText();
    }


}
