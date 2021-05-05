import com.codeborne.selenide.ElementsCollection;
import config.StartConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class StartTest extends TestBase{

    @Test
    public void testStartConfig() {

        final StartConfig config = ConfigFactory.create(StartConfig.class, System.getProperties());

        System.out.println(config.browser());
        System.out.println(config.browserVersion());
        System.out.println(config.keyUrl());

        open(config.keyUrl());
        $(".header-search-input").setValue(config.repository()).submit();

        ElementsCollection resaultSearch = $$(".repo-list > li");

        String h = (resaultSearch.size()) + " repository results";

        $(withText(h)).should(visible);

        $(By.linkText(config.repository())).click();
        $(withText(config.issues())).click();
        $(withText(config.issueNumber())).should(visible);
    }
}



