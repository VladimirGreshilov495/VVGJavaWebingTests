package tests;
import core.base.BaseTest;
import core.pages.RecoveryByPhonePage;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
    }
    @Test
    public void anonymRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();

    }

    @Test
    public void anonymRecoveryPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
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
        anonymRecoveryPage = new AnonymRecoveryPage();
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
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        RecoveryByPhonePage recoveryByPhone = new RecoveryByPhonePage();
        String countryCode = recoveryByPhone.selectCountryByName("Россия");
        assertEquals("+7", countryCode, "Код страны не совпадает с ожидаемым");
        String errorPhone = recoveryByPhone.selectPhoneNumber("99999");
        assertEquals("Неправильный номер телефона.", errorPhone, "Текст ошибки не совпадает");
    }

}


