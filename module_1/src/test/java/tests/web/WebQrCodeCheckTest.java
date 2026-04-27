package tests.web;
import core.base.BaseTest;
import core.pages.web.WebQrcodePage;
import core.pages.web.WebLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WebQrCodeCheckTest extends BaseTest {

    private static WebLoginPage loginPage;
    private static WebQrcodePage qrcodePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new WebLoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
    }

    @Test
    public void QrcodeCheckTest() {
        loginPage.openQrcodePage();

        qrcodePage = new WebQrcodePage();
        qrcodePage.clickToQrcode();


    }
}
