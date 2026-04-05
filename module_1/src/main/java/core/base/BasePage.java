package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    protected SelenideElement headerLogo = $(" [tsid='toolbar_logo'] ");
    protected SelenideElement searchField = $(" [name='st.query'] ");
    protected SelenideElement vkServices = $(" [data-l='t,vk_ecosystem'] ");
    protected SelenideElement acceptCookieButton = $(" #cb_accept ");
    protected SelenideElement acceptPrivacyButton = $(" .cmpbox_btn_yes ");
    private SelenideElement userDropdown = $x("//a[@class='toolbar_search_suggest-item']");


    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Принимаем куки")
    public void acceptCookie() {
        if (acceptCookieButton.exists()) {
            acceptCookieButton.click();
        }
    }

    @Step("Принимаем политику конфиденциальности")
    public void acceptPrivacyButton() {
        if (acceptPrivacyButton.exists()) {
            acceptPrivacyButton.click();
        }
    }

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query);
        userDropdown.shouldBe(visible).click();
    }
}


