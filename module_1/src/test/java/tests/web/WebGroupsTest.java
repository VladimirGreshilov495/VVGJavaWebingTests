package tests.web;
import core.base.BaseTest;
import core.pages.web.WebLoginPage;
import core.pages.web.WebGroupsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.WebDriverRunner;

public class WebGroupsTest extends BaseTest {
    private static WebLoginPage loginPage;
    private static WebGroupsPage groupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new WebLoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
        loginPage.search("тестировщик");
    }

    @Test
    public void searchTest() {
        // Переходим на страницу "группы"
        groupsPage = new WebGroupsPage();
        String expectedUrl = "https://ok.ru/groups";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }
}
