package tests.mob;


import core.base.MobileBaseTest;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobStartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobLoginWithWrongCredentialsTest extends MobileBaseTest {

    private static MobStartPage startPage;
    private static MobLoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startPage = new MobStartPage();
    }


    @Test
    public void emptyLoginTest() {
        // Попытка входа с некорректными данными
        startPage.enterPage();
        loginPage = new MobLoginPage();
        loginPage.login("", "incorrectPassword");

        // Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void emptyPasswordTest() {
        // Попытка входа с некорректными данными
        startPage.enterPage();
        loginPage = new MobLoginPage();
        loginPage.login("incorrectUser", "");


        // Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}