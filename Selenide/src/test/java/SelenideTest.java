import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public static void selenide() {
        open("https://www.selenium.dev");
        $(By.linkText("Documentation")).click();
        $x("//a[@class = 'nav-link active tab-java']").shouldHave((Condition.text("Java")));
    }
}