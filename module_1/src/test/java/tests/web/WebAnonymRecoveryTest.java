package tests.web;
import core.base.BaseTest;
import core.pages.web.WebRecoveryByPhonePage;
import core.pages.web.WebAnonymRecoveryPage;
import core.pages.web.WebLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebAnonymRecoveryTest extends BaseTest {

    private static WebLoginPage loginPage;
    private static WebAnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new WebLoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
    }


    @Test
    public void anonymSupportTest() throws InterruptedException {

        loginPage.goToCanNotEntry();
        anonymRecoveryPage = new WebAnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        anonymRecoveryPage.supportChat();
        anonymRecoveryPage.exitChat();
        anonymRecoveryPage.approveExitChat();

    }

    @Test
    public void anonymRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new WebAnonymRecoveryPage();

    }



    @Test
    public void anonymRecoveryPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new WebAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
    }

    @Test
    public void anonymRecoveryMailTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new WebAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();

    }
    @Test
    public void anonymRecoveryErrorPhoneNumber() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new WebAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        WebRecoveryByPhonePage recoveryByPhone = new WebRecoveryByPhonePage();
        String countryCode = recoveryByPhone.selectCountryByName("Россия");
        assertEquals("+7", countryCode, "Код страны не совпадает с ожидаемым");
        String errorPhone = recoveryByPhone.selectPhoneNumber("99999");
        assertEquals("Неправильный номер телефона.", errorPhone, "Текст ошибки не совпадает");
    }

}


