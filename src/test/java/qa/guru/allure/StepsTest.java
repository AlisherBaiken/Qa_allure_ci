package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String Repository = "eroshenkoam/allure-example";
    private static final int Issue  = 81;
    @Test
    public void testLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", ()->{
           open("https://github.com");
       });
        step("Ищем репозитори" + Repository, ()->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Repository);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория" + Repository,()->{
            $(linkText(Repository)).click();
        });
        step("Открываем таб Issues",()->{
            $("#issues-tab").click();
        });
        step("Проверяем Issue с номером " + Issue,()->{
            $(withText("#"+ Issue)).should(Condition.exist);
        });
    }
    @Test
    public void annotatedTestSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(Repository);
        steps.clickOnRepository(Repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumder(Issue);

    }
}
