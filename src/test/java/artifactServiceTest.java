import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide.open;


public class artifactServiceTest {
    @Test
    void shouldSubmitRequest() {

        open ("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$ ("[data-test-id=name]input").setValue("Василий");
        form.$ ("[data-test-id=phone]input").setValue("+79270000000");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[data-test-id=submit]").click();
        $ (".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}

