package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {
    private static final String Repository = "eroshenkoam/allure-example";
    private static final int Issue  = 81;
    @Test
    public void testLambdaAttachmentsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", ()->{
           open("https://github.com");
           attachment("Source",webdriver().driver().source());
       });

    }
    @Test
    public void annotatedAttachmentsTestSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenShot();

    }
}
