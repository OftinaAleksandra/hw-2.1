import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ArtifactServiceTest {

    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @Test
    void shouldSubmitRequest() {
        setUp();

        open ("http://localhost:9999");

        SelenideElement form = $("[method=post]");
        form.$ ("[data-test-id=name] input").setValue("Иванов Иван");
        form.$ ("[data-test-id=phone] input").setValue("+79270000000");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[role=button] ").click();
        $ ("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

