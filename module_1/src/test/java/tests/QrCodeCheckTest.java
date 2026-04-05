package tests;
import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.QrcodePage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class QrCodeCheckTest extends BaseTest {

    private static LoginPage loginPage;
    private static QrcodePage qrcodePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
    }

    @Test
    public void QrcodeCheckTest() {
        loginPage.openQrcodePage();

        qrcodePage = new QrcodePage();
        qrcodePage.clickToQrcode();


    }
}
