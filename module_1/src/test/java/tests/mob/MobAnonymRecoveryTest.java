package tests.mob;

import core.base.BaseTest;
import core.base.MobileBaseTest;
import core.pages.mob.MobAnonymRecoveryPage;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobRecoveryByPhonePage;
import core.pages.mob.MobStartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobAnonymRecoveryTest extends MobileBaseTest {

    private static MobStartPage startPage;
    private static MobLoginPage loginPage;
    private static MobAnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startPage = new MobStartPage();
    }


    @Test
    public void anonymRecoveryPhoneTest() throws InterruptedException {
        startPage.enterPage();
        loginPage = new MobLoginPage();
                loginPage.login("incorrectUser", "incorrectPassword");


        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new MobAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
    }

    @Test
    public void anonymRecoveryMailTest() {
        startPage.enterPage();
        loginPage = new MobLoginPage();
                loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new MobAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();

    }
    @Test
    public void anonymRecoveryErrorPhoneNumber() throws InterruptedException {
        startPage.enterPage();
        loginPage = new MobLoginPage();
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new MobAnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        MobRecoveryByPhonePage recoveryByPhone = new MobRecoveryByPhonePage();
        String countryCode = recoveryByPhone.selectCountryByName("Россия");
        assertEquals("+7", countryCode, "Код страны не совпадает с ожидаемым");
        String errorPhone = recoveryByPhone.selectPhoneNumber("99999");
        assertEquals("Введен неверный номер телефона", errorPhone, "Текст ошибки не совпадает");
    }

}


