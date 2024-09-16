import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitEnterprize {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";// Увеличиваем размер окна для видимости элементов
        Configuration.baseUrl = "https://github.com/";//обсалютный путь
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;//оставлять браузер открытый после теста
        Configuration.timeout = 5000; // default 4000

    }

    @Test
    void enterprise() {
        open("https://github.com/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(".mb-3").$(byText("Enterprise")).click();
        sleep(10);
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered\ndeveloper platform"));

    }
}
