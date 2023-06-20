package guru.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestInputName {

    @ValueSource(
            strings = {"совок", "коврик"}
    )
    @DisplayName("Проверка правильности отображаемого имени товара на строке найденных товаров")
    @ParameterizedTest
    void itemNames(String displayName) {
        open("https://fix-price.com");
        $(".search-input").setValue(displayName).pressEnter();
        $$(".page-title").shouldHave(texts(displayName));
    }
}
