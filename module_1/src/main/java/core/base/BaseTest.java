package core.base;


import com.codeborne.selenide.Configuration;

public class BaseTest extends AbstractBaseTest {


    @Override
    protected void configure() {
        Configuration.browser = "chrome";
    }
}

