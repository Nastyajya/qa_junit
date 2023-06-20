package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestUniversity {

    @ValueSource (
            strings = {"совок", "коврик"}
    )
    @DisplayName("Возле данных должны присутсовать их названия")
    @ParameterizedTest
    void itemNames (String value){
        open("https://fix-price.com");
        $(".search-input").setValue(value).pressEnter();
        $$(".page-title").shouldHave(texts(value));




    }
}
