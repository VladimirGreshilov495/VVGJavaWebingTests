package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WebQrcodePage extends BasePage {

    private SelenideElement qrCodePicture = $x("//*[contains(@class, 'qr_code_image')]");
    SelenideElement qrCodeImage = $(By.xpath("//img[@class='qr_code_image']"));

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость QR код")
    private void verifyPageElements() {
        qrCodePicture.shouldBe(visible);
    }

    @Step("Проверяем что QR код отображается для пользователя")
    public void clickToQrcode() {
        qrCodeImage.shouldBe(visible);
        String src = qrCodeImage.getAttribute("src");
        assertNotNull(src, "Атрибут src у изображения QR-кода пуст");
    }
}
