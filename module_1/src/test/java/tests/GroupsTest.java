package tests;
import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.GroupsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.WebDriverRunner;

public class GroupsTest extends BaseTest {
    private static LoginPage loginPage;
    private static GroupsPage groupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
        loginPage.search("тестировщик");
    }

    @Test
    public void searchTest() {
        // Переходим на страницу "группы"
        groupsPage = new GroupsPage();
        String expectedUrl = "https://ok.ru/groups";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }
}
