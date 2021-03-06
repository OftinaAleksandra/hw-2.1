import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ArtifactServiceTest {

    @BeforeAll
    public static void setUp() {
        System.setProperty("chromeoptions.args", "--no-sandbox,--headless,--disable-dev-shm-usage");
    }

    @Test
    void shouldSubmitRequest() {
        open ("http://localhost:9999");

        SelenideElement form = $("[method=post]");
        form.$ ("[data-test-id=name] input").setValue("Иванов Иван");
        form.$ ("[data-test-id=phone] input").setValue("+79270000000");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[role=button] ").click();
        $ ("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

