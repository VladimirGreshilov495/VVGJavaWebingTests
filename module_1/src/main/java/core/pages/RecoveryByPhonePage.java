package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RecoveryByPhonePage extends BasePage {

    //Локатор для кнопки выбора страны
    private SelenideElement countryDropdown = $x("//div[@data-l='t,country']");

    //Локатор для поля ввода номера телефона
    private SelenideElement phoneInputField = $("[name='st.r.phone']");

    //Локатор для нажатия по кнопке "Получить код"
    private SelenideElement goToGetCodeButton = $("input[data-l='t,submit']");

    //Локатор прокерки телефона
    private SelenideElement errorPhoneNumber = $x("//div[contains(@class,'js-ph-vl-hint')]");

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
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
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
