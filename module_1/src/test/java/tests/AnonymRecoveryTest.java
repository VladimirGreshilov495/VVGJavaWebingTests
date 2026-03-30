package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

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
}


