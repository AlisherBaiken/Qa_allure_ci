package qa.guru.allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;


public class WebSteps {


    @Step("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com");
    }
    @Step("Ищем репозитори {repo}" )
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step ("Кликаем по ссылке репозитория {repo}" )
    public void clickOnRepository(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем таб Issues" )
    public void openIssuesTab(){
        $("#issues-tab").click();
    }
    @Step ("Проверяем Issue с номером {Issue}")
    public void shouldSeeIssueWithNumder(int Issue){

        $(withText("#"+ Issue)).should(Condition.exist);
    }
    @Attachment(value = "ScreenShot", type = "img/png",fileExtension = "png")
    public byte[] takeScreenShot(){

      return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
